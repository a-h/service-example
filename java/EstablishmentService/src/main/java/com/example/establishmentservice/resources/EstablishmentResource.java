package com.example.establishmentservice.resources;

import com.example.establishmentservice.api.Establishment;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
