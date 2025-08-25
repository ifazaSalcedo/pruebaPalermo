package com.plan.bk.data.services.pedido.uc;

import com.plan.bk.dto.PedidoDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PedidoSaveUC {

    Optional<PedidoDto> savePedido(PedidoDto pedido);

}
