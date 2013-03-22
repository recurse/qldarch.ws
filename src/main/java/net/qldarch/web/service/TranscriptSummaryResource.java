package net.qldarch.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/transcriptSummary")
public class TranscriptSummaryResource {
    public static Logger logger = LoggerFactory.getLogger(TranscriptSummaryResource.class);

    @GET
    @Produces("application/json")
    public String performGet() {
        return new SparqlToJsonString().performQuery(
                "PREFIX :<http://qldarch.net/ns/rdf/2012-06/terms#> " +
                "select ?s ?p ?o from <http://qldarch.net/ns/omeka-export/2013-02-06> where {" +
                "  ?s a :Transcript ." +
                "  ?s ?p ?o ." +
                " }");
    }
}
