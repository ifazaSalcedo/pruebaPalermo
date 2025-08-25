package com.plan.bk.data.repository;

import com.plan.bk.data.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @EntityGraph(attributePaths = {"categoria", "listaPrecios"})
    @Query("SELECT p FROM Producto p")
    Page<Producto> allProductoListaPrecios(PageRequest of);
}
