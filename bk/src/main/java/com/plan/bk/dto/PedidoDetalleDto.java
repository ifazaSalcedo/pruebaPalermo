package com.plan.bk.dto;

import lombok.Value;

import java.math.BigInteger;

@Value
public class PedidoDetalleDto {
     int item;
     long idProducto;
     BigInteger cantidad;
     BigInteger precioUnitario;
     BigInteger subTotal;
}
