package com.plan.bk.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "PEDIDO_DET")
@NoArgsConstructor
@Getter
@Setter
public class PedidoDet {
    @EmbeddedId
    private PedidoDetPk pk;
    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "prd_codigo", referencedColumnName = "prd_codigo")
    private Producto producto;
    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "ped_codigo", referencedColumnName = "ped_codigo")
    private Pedido pedido;
    @Column(name = "detp_precio_uni", nullable = false)
    private BigInteger precioUnitario;
    @Column(name = "detp_sub_total", nullable = false)
    private BigInteger precioSubTotal;
}
