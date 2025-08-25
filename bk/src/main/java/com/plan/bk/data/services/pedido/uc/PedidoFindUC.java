package com.plan.bk.data.services.pedido.uc;

import com.plan.bk.dto.PedidoDto;

import java.time.LocalDate;
import java.util.List;

public interface PedidoFindUC {
    List<PedidoDto> findAllByFecha(LocalDate fecha);
}
