package com.distribuida.repo;

import com.distribuida.db.Producto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProductoRepository implements PanacheRepositoryBase<Producto, Long> {
}
