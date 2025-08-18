package com.plan.bk.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CLIENTE")
@NoArgsConstructor
@Getter
@Setter
public class Cliente {
    @Id
    @Column(name = "cli_codigo", nullable = false)
    private String codigo;
    @Column(name = "cli_nombre", nullable = false)
    private String nombre;
}
