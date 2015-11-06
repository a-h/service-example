package com.example.establishmentservice;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class EstablishmentServiceServiceConfiguration extends Configuration {
    @JsonProperty("mongodbConnectionString")
    private String mongodbConnectionString;

    public String getMongodbConnectionString() { return this.mongodbConnectionString; }

    public void setMongodbConnectionString(String value) { this.mongodbConnectionString = value; }

    @JsonProperty("maximumEstablishments")
    private int maximumEstablishments;

    public int getMaximumEstablishments() { return this.maximumEstablishments; }

    public void setMaximumEstablishments(int value) { this.maximumEstablishments = value; }
}
