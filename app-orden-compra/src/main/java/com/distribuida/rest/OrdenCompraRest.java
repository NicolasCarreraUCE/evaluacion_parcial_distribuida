package com.distribuida.rest;

import com.distribuida.db.OrdenCompra;
import com.distribuida.repo.OrdenCompraRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/orden-compra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class OrdenCompraRest extends Application {
    @Inject
    private OrdenCompraRepository repository;

    @GET
    public List<OrdenCompra> findAll() {
        return repository.findAll().list();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Optional<OrdenCompra> ordenCompra = repository.findByIdOptional(id);
        if (ordenCompra.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(ordenCompra.get()).build();
    }

    @POST
    public Response create(OrdenCompra ordenCompra) {
        repository.persist(ordenCompra);
        return Response.status(Response.Status.CREATED.getStatusCode(), "author created").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, OrdenCompra ordenCompraObj) {
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        repository.deleteById(id);

        return Response.ok().build();
    }
}
