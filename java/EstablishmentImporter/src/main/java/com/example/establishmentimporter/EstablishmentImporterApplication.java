package com.example.establishmentimporter;

import com.example.establishmentimporter.health.ImportHealthCheck;
import com.example.establishmentimporter.health.ImportStatus;
import com.example.establishmentimporter.processes.Importer;
import com.example.establishmentimporter.resources.StatusResource;
import com.mongodb.MongoClient;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ahesketh on 09/11/2015.
 */
public class EstablishmentImporterApplication extends Application<EstablishmentImporterConfiguration> {
    public static void main(String[] args) throws Exception {
        new EstablishmentImporterApplication().run(args);
    }

    @Override
    public String getName() {
        return "EstablishmentService";
    }

    @Override
    public void initialize(Bootstrap<EstablishmentImporterConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(EstablishmentImporterConfiguration configuration,
                    Environment environment) {
        Logger logger = (Logger) LoggerFactory.getLogger(EstablishmentImporterApplication.class);
        logger.debug("Starting to run the application.");
        logger.debug("File Name: {}", configuration.getFileName());
        logger.debug("Import Batch Size: {}", configuration.getImportBatchSize());

        // Register the status endpoint.
        logger.debug("Registering the status endpoint.");
        ImportStatus status = new ImportStatus();
        final StatusResource resource = new StatusResource(status);
        environment.jersey().register(resource);

        // Setup a health check.
        logger.debug("Setting up a health check");
        final ImportHealthCheck healthCheck = new ImportHealthCheck(configuration.getMongodbConnectionString());
        environment.healthChecks().register("template", healthCheck);

        // Start the import process.
        logger.debug("Starting the import process.");
        MongoClient client = new MongoClient(configuration.getMongodbConnectionString());
        final Importer importer = new Importer(client, configuration.getFileName(), configuration.getImportBatchSize(), status);
        importer.start();
    }
}
