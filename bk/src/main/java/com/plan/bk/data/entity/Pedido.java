package com.plan.bk.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PEDIDO")
@NoArgsConstructor
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_codigo", nullable = false)
    private Long codigo;
    @Column(name = "ped_fecha", nullable = false)
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo")
    private Cliente cliente;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoDet> detalle= new ArrayList<>();
    @Column(name = "ped_total", nullable = false)
    private BigInteger total;
}
