package com.redhat.samples.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

@Path("/")
public class Greeting {
  private static final Logger LOGGER = Logger.getLogger(Greeting.class);

  @GET
  @Path("/hello/{name}")
  @Produces({ "application/json" })
  @BadgerFish
  public Response hello(@PathParam("name") String name) {
    String message = String.format("Hello, %s!", name);
    LOGGER.info(message);
    return new Response(message);
  }

  @GET
  @Path("/goodbye/{name}")
  @Produces({ "application/xml" })
  public Response goodbye(@PathParam("name") String name) {
    String message = String.format("Goodbye, %s!", name);
    LOGGER.info(message);
    return new Response(message);
  }

}
