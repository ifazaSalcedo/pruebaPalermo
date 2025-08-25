package com.plan.bk.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CLIENTE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cli_documento"})
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_codigo", nullable = false)
    private Long codigo;
    @Column(name = "cli_documento", nullable = false)
    private String documento;
    @Column(name = "cli_nombre", nullable = false)
    private String nombre;
}
