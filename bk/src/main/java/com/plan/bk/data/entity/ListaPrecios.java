package com.plan.bk.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
@Entity
@Table(name = "PRODUCTO_PRECIOS")
@NoArgsConstructor
@Getter
@Setter
public class ListaPrecios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lpre_codigo")
    private Long codigo;
    @ManyToOne
    @JoinColumn(name = "prd_codigo", referencedColumnName = "prd_codigo")
    private Producto producto;
    @Column(name = "lpre_cantidad")
    private Integer cantidad;
    @Column(name = "lpre_precio")
    private BigInteger precio;
    @Column(name = "lpre_activo")
    private Integer activo;

}
