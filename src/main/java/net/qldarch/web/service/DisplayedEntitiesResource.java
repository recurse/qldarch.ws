package net.qldarch.web.service;

import org.openrdf.model.Literal;
import org.openrdf.model.Value;
import org.openrdf.query.*;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Path("/displayedEntities")
public class DisplayedEntitiesResource {
    public static Logger logger = LoggerFactory.getLogger(DisplayedEntitiesResource.class);
    public static final String XSD_BOOLEAN = "http://www.w3.org/2001/XMLSchema#boolean";


    @GET
    @Produces("application/json")
    public String performGet() {
        return new SparqlToJsonString().performQuery(
                "PREFIX :<http://qldarch.net/ns/rdf/2012-06/terms#> " +
                "select ?s ?p ?o from <http://qldarch.net/ns/rdf/2012-06/terms#> where {" +
                "  ?s a owl:Class ." +
                "  ?s :toplevel true ." +
                "  ?s ?p ?o ." +
                " }");
    }
}
