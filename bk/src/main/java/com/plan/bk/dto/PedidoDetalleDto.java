package com.plan.bk.dto;

import lombok.Value;

import java.math.BigInteger;

@Value
public class PedidoDetalleDto {
     long idPedido;
     long idProducto;
     int item;
     BigInteger cantidad;
     BigInteger precioUnitario;
     BigInteger subTotal;
}
