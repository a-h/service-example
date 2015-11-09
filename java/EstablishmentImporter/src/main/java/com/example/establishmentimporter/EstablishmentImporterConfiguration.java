package com.example.establishmentimporter;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Created by ahesketh on 09/11/2015.
 */
public class EstablishmentImporterConfiguration extends Configuration {
    @JsonProperty("mongodbConnectionString")
    private String mongodbConnectionString;

    public String getMongodbConnectionString() { return this.mongodbConnectionString; }

    public void setMongodbConnectionString(String value) { this.mongodbConnectionString = value; }

    @JsonProperty("importBatchSize")
    private int importBatchSize = 10;

    public int getImportBatchSize() { return this.importBatchSize; }

    public void setImportBatchSize(int value) { this.importBatchSize = value; }

    @JsonProperty("fileName")
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
