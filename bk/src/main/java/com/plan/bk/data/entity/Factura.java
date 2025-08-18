package com.plan.bk.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;
@Entity
@Table(name = "FACTURA")
@NoArgsConstructor
@Getter
@Setter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fac_codigo", nullable = false)
    private Long codigo;
    @Column(name = "fac_fecha", nullable = false)
    private LocalDate fecha;
//    @ManyToOne
//    @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo")
//    private Cliente cliente;
//    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<FacturaDet> detalle = new ArrayList<>();
    @Column(name = "fac_total", nullable = false)
    private BigInteger total;
}
