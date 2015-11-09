package com.example.establishmentservice.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.establishmentdatamodel.Establishment;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

@Path("/establishment")
@Produces(MediaType.APPLICATION_JSON)
public class EstablishmentResource implements Closeable {
    Logger logger = (Logger)LoggerFactory.getLogger(EstablishmentResource.class);
    private final MongoClient client;
    private final int maximumResults;

    public EstablishmentResource(MongoClient client, int maximumResults) {
        this.client = client;
        this.maximumResults = maximumResults;
    }

    @GET
    @Path("/{id}")
    public Establishment find(@PathParam("id") String id) {
        logger.debug("Searching for an establishment by Id {0}", id);

        MongoDatabase database = client.getDatabase("establishments");
        MongoCollection<Document> establishmentsCollection = database.getCollection("establishments");
        BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));

        Document d = establishmentsCollection.find(query).limit(1).first();

        return MapDocumentToEstablishment(d);
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public ArrayList<Establishment> list() throws IOException {
        logger.debug("Listing establishments");

        ArrayList<Establishment> results = new ArrayList<Establishment>();

        MongoDatabase database = client.getDatabase("establishments");
        MongoCollection<Document> establishmentsCollection = database.getCollection("establishments");

        for (Document d : establishmentsCollection.find().limit(this.maximumResults)) {
            results.add(MapDocumentToEstablishment(d));
        }

        return results;
    }


    private Establishment MapDocumentToEstablishment(Document d) {
        Establishment e = new Establishment();
        e.setId(d.getObjectId("_id").toString());
        e.setBusinessName(d.getString("BusinessName"));
        return e;
    }

    public void close() throws IOException {
        this.client.close();
    }
}
