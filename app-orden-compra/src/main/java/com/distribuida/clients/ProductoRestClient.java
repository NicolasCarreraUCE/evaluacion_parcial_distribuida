package com.distribuida.clients;

import com.distribuida.dto.ClienteDto;
import com.distribuida.dto.ProductoDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/producto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "ClienteRestClient")
public interface ProductoRestClient {
    @GET
    @Path("/{id}")
    ProductoDto findById(@PathParam("id") Long id);
}
