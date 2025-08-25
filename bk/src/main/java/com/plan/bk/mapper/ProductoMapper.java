package com.plan.bk.mapper;

import com.plan.bk.data.entity.ListaPrecios;
import com.plan.bk.data.entity.Producto;
import com.plan.bk.dto.ListaPrecioProductoDto;
import com.plan.bk.dto.ProductoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductoMapper {

    public static ProductoDto toDto(Producto producto){

        return new ProductoDto(producto.getCodigo(),
                producto.getCodigoBarra(),
                producto.getDescripcion(),
                producto.getPrecioCompra(),
                producto.getCategoria().getCodigo(),
                producto.getCategoria().getDescripcion(),
                producto.getListaPrecios().stream().map(ProductoMapper::toListaPreciosDto).collect(Collectors.toList()));
    }
    public static ListaPrecioProductoDto toListaPreciosDto(ListaPrecios lst){
        return new ListaPrecioProductoDto(lst.getCantidad(), lst.getPrecio(), lst.getActivo());
    }

    public static Producto toEntity(ProductoDto producto) {
        return null;
    }
}
