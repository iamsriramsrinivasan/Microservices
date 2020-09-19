package org.sriraminc.quarkus.samples.config;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/greeting")
public class GreetingResource {

	@Inject
	GreetingsConfiguration config;
	

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return config.getMessage() + " " + config.getName().orElse("world") + config.getSuffix();
    }
}