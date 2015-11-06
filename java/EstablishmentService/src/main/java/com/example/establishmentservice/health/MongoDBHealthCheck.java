package com.example.establishmentservice.health;

import com.codahale.metrics.health.HealthCheck;

public class MongoDBHealthCheck extends HealthCheck {
    private final String connectionString;

    public MongoDBHealthCheck(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    protected Result check() throws Exception {
        // TODO: Check connection is up and there's an active primary.
        return Result.healthy();
    }
}
