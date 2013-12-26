package com.redhat.samples.rest;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.spi.interception.MessageBodyWriterContext;
import org.jboss.resteasy.spi.interception.MessageBodyWriterInterceptor;

@Provider
@ServerInterceptor
public class CorsInterceptor implements MessageBodyWriterInterceptor {

    private static final Logger LOGGER = Logger.getLogger(CorsInterceptor.class);

    @Override
    public void write(MessageBodyWriterContext context) throws IOException, WebApplicationException {
        LOGGER.info(getClass().getSimpleName() + " invoked.");
        context.getHeaders().add("Access-Control-Allow-Origin", "http://localhost:18080");
        context.proceed();
    }

}
