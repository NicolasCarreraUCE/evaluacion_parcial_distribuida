package com.distribuida.rest;

import com.distribuida.db.Cliente;
import com.distribuida.repo.ClienteRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class ClienteRest {
    @Inject
    private ClienteRepository repository;

    @GET
    public List<Cliente> findAll() {
        return repository.findAll().list();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Optional<Cliente> cliente = repository.findByIdOptional(id);
        if (cliente.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cliente.get()).build();
    }

    @POST
    public Response create(Cliente cliente) {
        repository.persist(cliente);
        return Response.status(Response.Status.CREATED.getStatusCode(), "author created").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Cliente clienteObj) {
        Cliente cliente = repository.findById(id);
        cliente.setNombre(clienteObj.getNombre());
        cliente.setApellido(clienteObj.getApellido());
        cliente.setDireccion(clienteObj.getDireccion());

        repository.persistAndFlush(cliente);

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        repository.deleteById(id);

        return Response.ok().build();
    }
}
