package com.plan.bk.data.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "PRODUCTO")
@NoArgsConstructor
@Getter
@Setter
public class Producto {

    @Id
    @Column(name = "prd_codigo", nullable = false)
    private String codigo;
    @Column(name = "prd_descrip", nullable = false)
    private String descripcion;
    @Column(name = "prd_precio_com", nullable = true)
    private BigInteger precioCompra;
    @Column(name = "prd_precio_venta", nullable = false)
    private BigInteger precioVenta;
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "cat_codigo", referencedColumnName = "cat_codigo", nullable = false)
    private Categoria categoria;

}
