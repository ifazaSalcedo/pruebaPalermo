package com.plan.bk.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDetPk implements Serializable {
    @Column(name = "detf_item", nullable = false)
    private Integer item;
    @Column(name = "fac_codigo", nullable = false)
    private Long idFactura;
    @Column(name = "prd_codigo", nullable = false)
    private String idProducto;
}
