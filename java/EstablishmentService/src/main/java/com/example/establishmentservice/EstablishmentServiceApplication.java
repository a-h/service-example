package com.example.establishmentservice;

import com.mongodb.MongoClient;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.establishmentservice.resources.EstablishmentResource;
import com.example.establishmentservice.health.MongoDBHealthCheck;

public class EstablishmentServiceApplication extends Application<EstablishmentServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new EstablishmentServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "EstablishmentService";
    }

    @Override
    public void initialize(Bootstrap<EstablishmentServiceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(EstablishmentServiceConfiguration configuration,
                    Environment environment) {
        // TODO: Pass configuration parameters to the resource.
        System.out.println(configuration.getMaximumEstablishments());

        MongoClient client = new MongoClient(configuration.getMongodbConnectionString());
        final EstablishmentResource resource = new EstablishmentResource(client,
                configuration.getMaximumEstablishments());
        final MongoDBHealthCheck healthCheck =
                new MongoDBHealthCheck(configuration.getMongodbConnectionString());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
