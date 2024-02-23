package com.distribuida.clients;

import com.distribuida.dto.ClienteDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "ClienteRestClient")
public interface ClienteRestClient {
    @GET
    @Path("/{id}")
    ClienteDto findById(@PathParam("id") Long id);

}
