package com.plan.bk.dto;

import lombok.Value;

import java.math.BigInteger;

@Value
public class ListaPrecioProductoDto {
     Integer cantidad;
     BigInteger precio;
     Integer activo;
}
