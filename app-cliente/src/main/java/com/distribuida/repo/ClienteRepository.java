package com.distribuida.repo;

import com.distribuida.db.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ClienteRepository implements PanacheRepositoryBase<Cliente, Long> {
}
