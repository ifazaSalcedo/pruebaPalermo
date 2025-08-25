package com.plan.bk.data.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTO",
uniqueConstraints = {
        @UniqueConstraint(columnNames = {"prd_cod_barra"})
})
@NoArgsConstructor
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prd_codigo", nullable = false)
    private Long codigo;
    @Column(name = "prd_cod_barra", nullable = false)
    private String codigoBarra;
    @Column(name = "prd_descrip", nullable = false)
    private String descripcion;
    @Column(name = "prd_precio_com", nullable = true)
    private BigInteger precioCompra;
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "cat_codigo", referencedColumnName = "cat_codigo", nullable = false)
    private Categoria categoria;
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<ListaPrecios> listaPrecios= new ArrayList<>();

}
