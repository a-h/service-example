package com.example.establishmentdatamodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;

/**
 * Created by ahesketh on 09/11/2015.
 */
public class EstablishmentConverter {
    public static Establishment fromJson(String line) throws IOException {
        return new ObjectMapper().readValue(line, Establishment.class);
    }

    public static String toJson(Establishment e) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(e);
    }
}
