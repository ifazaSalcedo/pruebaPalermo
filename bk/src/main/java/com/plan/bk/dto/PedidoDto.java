package com.plan.bk.dto;

import lombok.Value;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Value
public class PedidoDto {
     Long codigo;
     LocalDate fecha;
     Long idCliente;
     BigInteger total;
    List<PedidoDetalleDto> detalle;
}
