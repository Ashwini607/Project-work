### Written in blue are links

# Stuffs related to RDF modeling 

 I have used Eclipse Java development tools and library of Apache Jena to make rdf model in different serialisation such as N-triples, Turtle, RDF/XML, and N3.

 To know more about Apache Jena just [click](http://jena.apache.org)

 Complete guide for beginner to start Jena project in Eclipse just [click](http://www.iandickinson.me.uk/articles/jena-eclipse-helloworld/)   

- [Java programing for making model using Eclipse]( https://github.com/Ashwini607/Project-work/blob/master/Documents/workspace/trial/src/trial)  
- [Result of models in different RDF serialisation](https://github.com/Ashwini607/Project-work/blob/master/Documents)

---
# SPARQL query for metadata

 If you are new in querying rdf triple store then you can try these queries, because these work on any sparql endpoint. It will help to get familiar with contains of triple store.  
 
- [Retrieve all available triples from triple store](https://github.com/Ashwini607/Project-work/blob/master/Documents/EBIDatabase/query/metadataQuery1.rq)
- [Retrieve all types from triple store](https://github.com/Ashwini607/Project-work/blob/master/Documents/EBIDatabase/query/metadataQuery2.rq)
- [Retrieve triples which is Subclassof other triple from triple store](https://github.com/Ashwini607/Project-work/blob/master/Documents/EBIDatabase/query/metadataQuery3.rq)
- [Retrieve all labeled triple from triple store](https://github.com/Ashwini607/Project-work/blob/master/Documents/EBIDatabase/query/metadataQuery4.rq)

---
# CHEMBL SPARQL query

 I have kept the chembl triple store queries in a folder /Documents/git/ChEMBL-RDF-queries. We can directly run the query, using terminal but for running on sparql-endpoint of chembl triple store, remove the comment from the query. 

 Note: Try to avoid the use of filter function in SPARQL query, because it takes more time for running.

 In some of the quiries, I have used the filter function even is not needed but just to make extra column which give satisfaction for correct output. I helps If you are new for triple store.
For example, I am interested in chembl-ID of molecules having activity standard type "IC50" then we can put "IC50" value at standard type but to make a extra column to show that I have selected the correct standard type, can use filter. We can add standard type as a
new column having constant text "IC50" without filter. These differences make change in running time of query. To analyse this kind of changes, I have made query for about same problem in different way like last 5 chembl queries.  

 chembl sparql-endpoint is available at -[click](http://www.ebi.ac.uk/rdf/services/chembl/sparql?)

 Some of the Queries related to ChEMBL sparql endpoint are mention below: 

- [Retrieve chembl molecule on the basis of trade name](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/moleculeSourceForTradeName.rq)
- [Retrieve the molecular formula of chembl molecule having chembl-id "CHEMBL192"](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/molFormulaof192Molecule.rq)
- [Retrieve rotational bond of chembl molecule having chembl-id  "CHEMBL192"](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/rotbonOf192Molecule.rq)
- [Retrieve trade name of CHEMBL192 molecule](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/tradeNameOf192Molecule.rq)
- [Retrieve the chembl molecules sources having molecular formula is combination of “C22H30N6O4S”](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/sourceForMolecularFormula.rq)
- [Retrieve substance types having target type "cell-line"](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/substanceTypeToCell-line.rq)
- [Retrieve target types available in chembl rdf triple store](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/targetType.rq)
- [Retrieve compound activity details for all target](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/compoundActDetails.rq)
- [Retrieve all the bioactive chembl molecules for bacterial target](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/bacterialTargetData.rq)
- [Retrieve chembl molecules targeting “Firefly Luciferase”](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/compoundToFirLuciferase.rq)
- [Retrieve target details, uniprot_reference and sequences for proteins target](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/compoundDetailsForProteinTar.rq)
- [Retrieve chembl molecules activity details for all targets containing a protein of interest, and protein of interest is human M2 muscarinic receptor (P08172)](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/P08172CompActAssTarDet.rq)
- [Retrieve chembl molecules activity details for a target, and target is Human PDE5 (CHEMBL1827)](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/detailsForTarget.rq)
- [Retrieve chembl molecules activity details for all target](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/compoundActDetails.rq)
- [Retrieve chembl molecules chembl-ID, activity standard type, activity standard unit having activity standard type "IC50" and standard unit "nM" using Filter](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/IC50Compounds.rq)
- [Retrieve chembl molecules chembl-ID having activity standard type "IC50" and activity standard unit "nM"](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/IC50Compounds_1.rq)
- [Retrieve chembl molecules chembl-ID having activity standard type "IC50" and activity standard unit "nM" having extra columns with variable name that contain constant text about standard type and standard unit](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/IC50Compounds_2.rq)
- [Retrieve chembl molecules chembl-ID having activity standard type "IC50" and activity standard unit "nM" having extra columns that contains constant text about standard type and standard unit](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/IC50Compounds_3.rq)
- [Retrieve chembl molecules chembl-ID, activity standard type, activity standard unit having activity standard type "IC50" and standard unit "nM" using Filter but two conditions in a single filter](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/ChEMBL-RDF-queries/IC50Compounds_4.rq)


---

# Shell Script

 Timing in running query may be different if you run a same query again and again, so I have made the script to run the same query many times and get the running time in a separate file for analysis. 
Same problem but different query like using filter, not using filter, adding extra text column to output has kept in a single shell script but gives different time calculating file for each query. It can help to make efficient code. 
rsparql meme is a execution file for sparql query present in bin directory of Apache-Jena folder that we changed for need some more space to run query and the name of new execution file is -[rsparqlmem](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/bin/rsparqlmem). 
- [Most of them are for analysing the running time of sparql query to make more efficient code](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/bin)
