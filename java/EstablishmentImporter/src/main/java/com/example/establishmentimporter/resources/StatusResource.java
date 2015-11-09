package com.example.establishmentimporter.resources;

import com.example.establishmentimporter.health.ImportStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by ahesketh on 09/11/2015.
 */
@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
public class StatusResource {
    Logger logger = (Logger) LoggerFactory.getLogger(StatusResource.class);

    private ImportStatus status;

    public StatusResource(ImportStatus status) {
        this.status = status;
    }

    @GET
    @Path("/")
    public ImportStatus get() {
        return status;
    }
}
