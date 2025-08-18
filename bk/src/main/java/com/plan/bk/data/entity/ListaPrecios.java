package com.plan.bk.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

public class ListaPrecios {

    private Long codigo;
//    @ManyToOne
//    @JoinColumn(name = "prod_codigo", referencedColumnName = "prod_codigo")
//    private Producto producto;

    private Integer cantidad;

    private BigInteger precio;

    private Integer activo;

}
