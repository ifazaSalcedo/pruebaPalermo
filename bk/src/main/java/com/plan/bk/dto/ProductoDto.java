package com.plan.bk.dto;


import com.plan.bk.data.entity.ListaPrecios;
import lombok.Value;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Value
public class ProductoDto {
     Long codigo;
     String codigoBarra;
     String descripcion;
     BigInteger precioCompra;
     Long categoriaId;
     String categoriaDes;
     List<ListaPrecioProductoDto> listaPrecios;
}
