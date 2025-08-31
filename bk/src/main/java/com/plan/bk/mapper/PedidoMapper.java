package com.plan.bk.mapper;

import com.plan.bk.data.entity.Pedido;
import com.plan.bk.data.entity.PedidoDet;
import com.plan.bk.dto.PedidoDetalleDto;
import com.plan.bk.dto.PedidoDto;

public class PedidoMapper {
    public static PedidoDto toDto(Pedido pedido){
        return new PedidoDto(pedido.getCodigo(),
                pedido.getFecha(),
                pedido.getCliente().getCodigo(),
                pedido.getTotal(),
                pedido.getDetalle().stream().map(PedidoMapper::toDetalleDto).toList());
    }
    private static PedidoDetalleDto toDetalleDto(PedidoDet detalle){
        return new PedidoDetalleDto(detalle.getPk().getItem(),
                detalle.getPk().getIdProducto(),
                detalle.getCantidad(),
                detalle.getPrecioUnitario(),
                detalle.getPrecioSubTotal());
    }
}
