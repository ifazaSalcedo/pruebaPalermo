package com.plan.bk.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CATEGORIA")
@NoArgsConstructor
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_codigo")
    private Long codigo;
    @Column(name = "cat_descripcion", nullable = false)
    private String descripcion;
    @Column(name = "cat_cantidad_min")
    private Integer cantiMinimaVenta;
}
