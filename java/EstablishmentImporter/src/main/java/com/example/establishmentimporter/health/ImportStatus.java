package com.example.establishmentimporter.health;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;

/**
 * Created by ahesketh on 09/11/2015.
 */
public class ImportStatus {
    private Object lockObject = new Object();
    private DateTime startDate = DateTime.now();

    public void update(ExecutionStatus status, int successfulOperations, int failedOperations)
    {
        long currentWorkingSet = ImportStatus.getMemoryConsumption();

        synchronized (this.lockObject)
        {
            this.setStatus(status);
            this.setWorkingSet(currentWorkingSet);
            this.operations += successfulOperations;
            this.exceptions += failedOperations;
            this.setUptime(new Period(startDate, DateTime.now()).toStandardDuration());
        }
    }

    private static long getMemoryConsumption() {
        return Runtime.getRuntime().totalMemory();
    }

    public ExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(ExecutionStatus status) {
        this.status = status;
    }

    public ExecutionStatus status;


    public long getOperations() {
        return operations;
    }

    public void setOperations(long operations) {
        this.operations = operations;
    }

    public long operations;

    public long getExceptions() {
        return exceptions;
    }

    public void setExceptions(long exceptions) {
        this.exceptions = exceptions;
    }

    public long exceptions;

    public Duration getUptime() {
        return uptime;
    }

    public void setUptime(Duration uptime) {
        this.uptime = uptime;
    }

    public Duration uptime;

    public long getWorkingSet() {
        return workingSet;
    }

    public void setWorkingSet(long workingSet) {
        this.workingSet = workingSet;
    }

    public long workingSet;
}
