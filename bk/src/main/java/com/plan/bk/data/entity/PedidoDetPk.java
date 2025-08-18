package com.plan.bk.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PedidoDetPk implements Serializable {
    @Column(name = "detp_item")
    private Integer item;
    @Column(name = "ped_codigo")
    private Long idPedido;
    @Column(name = "prd_codigo")
    private String idProducto;
}
