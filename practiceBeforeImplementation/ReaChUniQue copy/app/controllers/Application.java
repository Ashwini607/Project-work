package controllers;

import java.io.PrintStream;
import java.io.Writer;
import java.util.*;

import play.*;
import play.db.jpa.GenericModel.JPAQuery;
import play.db.jpa.JPABase;
import play.mvc.*;

import java.util.*;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;

import models.*;

import com.hp.hpl.jena.query.*;
public class Application extends Controller {

	public static void index() {
		List<Protein> proteins = Protein.findAll();
		List<Substance> compounds = Substance.findAll();
		Substance s1 = new Substance("C2H6",30, "Ethane");
		Protein p1 = new Protein("Cytoplasm", "Cancer", "RRRRRR", "PGB", s1);
		Protein p2 = new Protein("Cytoplasm", "Cancer", "RRRRR", "PGV", s1);
	    int y = p1.getSimilarity(p2);
		render(proteins, compounds,y);
	}
	//Pseudo-code:
	//Print a message saying the query is being executed
	//TODO do a SPARQL query
	//Need a way to run a SPARQL query (jena library)
	//Set the Jena library deps
	//See the class for SPARQL query
	//Print the results in console
	//Try to think how it can be integrated with the view
	//Which end-point are we going to use?
	//Need to have a "debug" SPARQL query
	//Print a message saying the query is done

	public static void sparql() {
		List <String> myList = new ArrayList();
		String queryString = 
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n " +
						"PREFIX skos: <http://www.w3.org/2004/02/skos/core#> \n" +
						"SELECT ?tradeName\n" +
						"	WHERE { \n" +
						"<http://rdf.ebi.ac.uk/resource/chembl/molecule/CHEMBL192> skos:altLabel ?tradeName.\n" + 
						"}\n";

		QueryExecution qExe = QueryExecutionFactory.sparqlService("http://www.ebi.ac.uk/rdf/services/chembl/sparql", queryString);
		ResultSet results = qExe.execSelect();
		for ( ; results.hasNext() ; )
		{
			QuerySolution soln = results.nextSolution() ;
			RDFNode x = soln.get("tradeName") ;       // Get a result variable by name.
			System.out.println(x);
			Resource r = soln.getResource("VarR") ; // Get a result variable - must be a resource
			Literal l = soln.getLiteral("VarL") ;   // Get a result variable - must be a literal
			myList.add(x.toString() + "\n");			
		}
		//ResultSetFormatter.out(System.out, results) ;
		qExe.close();
		render(myList);
	}

	public static void test(String id){
		String ChEMBLQuery = 
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n " +
						"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
						"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n" +
						"SELECT ?molfor\n" +
						//"CONSTRUCT {<http://rdf.ebi.ac.uk/resource/chembl/molecule/" + id + "#full_molformula> rdfs:label ?molfor.} \n" +
						"WHERE {\n" +
						"<http://rdf.ebi.ac.uk/resource/chembl/molecule/" + id + "#full_molformula> rdfs:label ?molfor.\n" +
						"}\n";
		QueryExecution qExe = QueryExecutionFactory.sparqlService("http://www.ebi.ac.uk/rdf/services/chembl/sparql", ChEMBLQuery);

		ResultSet results = qExe.execSelect();

		for ( ; results.hasNext() ; )
		{
			QuerySolution soln = results.nextSolution() ;
			RDFNode x = soln.get("molfor") ;       // Get a result variable by name.
			System.out.println(x + "\n");
			Resource r = soln.getResource("VarR") ; // Get a result variable - must be a resource
			Literal l = soln.getLiteral("VarL") ;   // Get a result variable - must be a literal
			render(x);

		}
		//ResultSetFormatter.out(System.out, results) ;	 
		qExe.close() ;
		//Logger.info(results.toString());
		//render(results);
	} 

	public static void disease(String id){
		List <String> myList = new ArrayList();
		List <String> myList1 = new ArrayList();
		List <String> myList2 = new ArrayList();
		String diseaseSearch = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n" +
				"PREFIX owl: <http://www.w3.org/2002/07/owl#> \n" +
				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> \n" +
				"PREFIX skos: <http://www.w3.org/2004/02/skos/core#> \n" +
				"PREFIX up:<http://purl.uniprot.org/core/>\n " + 

			"SELECT ?protein  ?disease ?aa \n" +
			"WHERE { \n" +
			"  SERVICE <http://beta.sparql.uniprot.org/sparql> { \n" +
			"  ?protein a up:Protein.\n " +
			"  ?protein up:sequence ?seq. \n" +
			"  ?seq rdf:value ?aa.\n " +
			"  ?protein up:annotation ?annotation. \n" +
			"  ?annotation up:disease ?dis.\n" +
			"  ?dis skos:prefLabel ?disease . \n" + 
			"  FILTER regex(?disease, 'Alzheimer', 'i')" +
			"}\n" +
			"}\n";
		Query query = QueryFactory.create(diseaseSearch);
		QueryExecution qExe = QueryExecutionFactory.sparqlService("http://www.ebi.ac.uk/rdf/services/chembl/sparql", query);
        //myList.add("Protein" +"\t"+ "Disease" +"\t"+ "ProteinSequence");
		ResultSet results = qExe.execSelect();
		for ( ; results.hasNext() ; )
		{
			QuerySolution soln = results.nextSolution() ;
			RDFNode x = soln.get("protein") ;       // Get a result variable by name.
			RDFNode y = soln.get("disease") ; 
			RDFNode z = soln.get("aa") ; 
			myList.add(x.toString() +"\t"+ y.toString() +"\t"+ z.toString());
			//myList1.add(y.toString());
			//myList2.add(z.toString());
		}
		//ResultSetFormatter.out(System.out, results) ;
		qExe.close();
		render(myList, myList1, myList2 );

	}
}
