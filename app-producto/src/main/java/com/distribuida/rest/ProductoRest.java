package com.distribuida.rest;

import com.distribuida.db.Producto;
import com.distribuida.repo.ProductoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/producto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class ProductoRest {
    @Inject
    private ProductoRepository repository;

    @GET
    public List<Producto> findAll() {
        return repository.findAll().list();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Optional<Producto> producto = repository.findByIdOptional(id);
        if (producto.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(producto.get()).build();
    }

    @POST
    public Response create(Producto producto) {
        repository.persist(producto);
        return Response.status(Response.Status.CREATED.getStatusCode(), "author created").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Producto productoObj) {
        Producto producto = repository.findById(id);
        producto.setNombre(productoObj.getNombre());
        producto.setPrecio(productoObj.getPrecio());

        repository.persistAndFlush(producto);

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        repository.deleteById(id);

        return Response.ok().build();
    }
}
