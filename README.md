In case you want to ask anything related to my work, contact me by mail ashwinikmr44@gmail.com

### Written in blue are links

 Github command [use me](https://github.com/Ashwini607/Project-work/blob/master/Documents/git/aboutGitCommand.md)

# Stuffs related to RDF modeling 

 I have used Eclipse Java development tools and library of Apache Jena to make RDF model in different serialisation such as N-triples, Turtle, RDF/XML, and N3.

 To know more about Apache Jena just go [http://jena.apache.org](http://jena.apache.org)

 Complete guide for beginner to start Jena project in Eclipse just go [http://www.iandickinson.me.uk/articles/jena-eclipse-helloworld/](http://www.iandickinson.me.uk/articles/jena-eclipse-helloworld/)   

- [Java programing for making model using Eclipse]( https://github.com/Ashwini607/Project-work/blob/master/Documents/workspace/trial/src/trial)  
- [Result of models in different RDF serialisation](https://github.com/Ashwini607/Project-work/blob/master/Documents)

 For example, you can see about a model "finalModel3": model written in Java [finalModel3.java](https://github.com/Ashwini607/Project-work/blob/master/Documents/workspace/trial/src/trial/finalModel3.java) + model output in different serialisations and queries related to this model [click to see it](https://github.com/Ashwini607/Project-work/tree/master/Documents/finalModel3)  
 You can visualise the model by uploading rdf file in RDF-Gravity tool. You can find it at [http://semweb.salzburgresearch.at/apps/rdf-gravity/](http://semweb.salzburgresearch.at/apps/rdf-gravity/)  

---

# Shell Script

 Timing in running query may be different if you run a same query again and again, so I have made the script to run the same query many times and get the running time in a separate file for analysis. 
Same problem but different query like using filter, not using filter, adding extra text column to output has kept in a single shell script but gives different time calculating file for each query. It can help to make efficient code. 

rsparql is a execution file for SPARQL query present in bin directory of Apache-Jena Java framework. We changed it for need of some more space to run the query, and the name of new execution file is [rsparqlmem](https://github.com/Ashwini607/Project-work/blob/master/Documents/bin/rsparqlmem). I have used this new file for running shell script file.
- [Most of them are for analysing the running time of SPARQL query to make more efficient code](https://github.com/Ashwini607/Project-work/blob/master/Documents/bin)
  
For example, Bacteria target analysis: used filter to select organism, not filter but kept name at the place of organism name and without filter but added just a extra fixed text column to show organism is Bacteria.
[Result](https://github.com/Ashwini607/Project-work/blob/master/Documents/bin/runTime.png)
