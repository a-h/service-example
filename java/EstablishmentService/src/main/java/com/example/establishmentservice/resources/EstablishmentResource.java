package com.example.establishmentservice.resources;

import com.example.establishmentservice.api.Establishment;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Establishment> get(@QueryParam("id") Optional<String> id) throws IOException {
        ArrayList<Establishment> results = new ArrayList<Establishment>();

        if (id.isPresent()) {
            Establishment e = new Establishment();
            e.setId("123");
            e.setBusinessName("Red Chilli");
            results.add(e);
        } else {
            MongoDatabase database = client.getDatabase("establishments");
            MongoCollection<Document> establishmentsCollection = database.getCollection("establishments");

            for (Document d : establishmentsCollection.find().limit(this.maximumResults)) {
                Establishment e = new Establishment();
                // e.setId(d.getObjectId("Id").toString());
                e.setBusinessName(d.getString("BusinessName"));

                results.add(e);
            }
        }

        return results;
    }

    public void close() throws IOException {
        this.client.close();
    }
}
