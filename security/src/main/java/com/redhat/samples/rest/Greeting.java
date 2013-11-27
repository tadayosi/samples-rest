package com.redhat.samples.rest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

@Path("/")
public class Greeting {
    private static final Logger LOGGER = Logger.getLogger(Greeting.class);

    @GET
    @Path("/hello/{name}")
    @Produces({ "application/json" })
    @RolesAllowed("guest")
    public String hello(@PathParam("name") String name) {
        String message = String.format("Hello, %s!", name);
        LOGGER.info(message);
        return String.format("{\"result\" : \"%s\"}", message);
    }

    @GET
    @Path("/goodbye/{name}")
    @Produces({ "application/xml" })
    @RolesAllowed("admin")
    public String goodbye(@PathParam("name") String name) {
        String message = String.format("Goodbye, %s!", name);
        LOGGER.info(message);
        return String.format("<goodbye><result>%s</result></goodbye>", message);
    }

}
