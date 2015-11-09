package com.example.establishmentimporter.health;

/**
 * Created by ahesketh on 09/11/2015.
 */

import com.codahale.metrics.health.HealthCheck;

public class ImportHealthCheck extends HealthCheck {
    private final String connectionString;

    public ImportHealthCheck(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    protected Result check() throws Exception {
        // TODO: Check connection is up and there's an active primary.
        return Result.healthy();
    }
}
