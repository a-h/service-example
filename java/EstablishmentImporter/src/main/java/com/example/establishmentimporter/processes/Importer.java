package com.example.establishmentimporter.processes;

import com.example.establishmentimporter.health.ExecutionStatus;
import com.example.establishmentimporter.health.ImportStatus;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by ahesketh on 09/11/2015.
 */
public class Importer {
    private final MongoClient client;
    private final int importBatchSize;
    private final ImportStatus status;
    private final String fileName;
    private final Logger logger = (Logger) LoggerFactory.getLogger(Importer.class);

    public Importer(MongoClient client, String fileName, int importBatchSize, ImportStatus status) {
        this.status = status;
        this.importBatchSize = importBatchSize;
        this.client = client;
        this.fileName = fileName;
    }

    public void start() {
        this.status.update(ExecutionStatus.RUNNING, 0, 0);

        try(Reader r = new FileReader(this.fileName))
        {
            MongoDatabase db = client.getDatabase("establishments");
            MongoCollection collection = db.getCollection("establishments");

            try(BufferedReader reader = new BufferedReader(r)) {
                int index = 0;
                String line = null;
                while ((line = reader.readLine()) != null) {
                    logger.debug("Importing line {} of file {}", index, this.fileName);

                    processLine(collection, line);

                    this.status.update(ExecutionStatus.RUNNING, 1, 0);

                    index++;
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("The file {} was not found to import.", this.fileName);
            this.status.update(ExecutionStatus.FAILED, 0, 1);
        } catch (IOException e) {
            logger.error("An error occurred processing file {}.", this.fileName);
            this.status.update(ExecutionStatus.FAILED, 0, 1);
        }
    }

    private void processLine(MongoCollection collection, String line) throws IOException {
        Document establishment = Document.parse(line);
        collection.insertOne(establishment);
    }
}
