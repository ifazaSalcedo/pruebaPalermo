package com.plan.bk.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "FACTURA_DET")
@NoArgsConstructor
@Getter
@Setter
public class FacturaDet {
    @EmbeddedId
    private FacturaDetPk pk;
    @ManyToOne
    @JoinColumn(name = "prd_codigo", referencedColumnName = "prd_codigo")
    @MapsId("idProducto")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "fac_codigo", referencedColumnName = "fac_codigo")
    @MapsId("idFactura")
    private Factura factura;
    @Column(name = "detf_precio_uni", nullable = false)
    private BigInteger precioUnitario;
    @Column(name = "detf_sub_total", nullable = false)
    private BigInteger precioSubTotal;
}
