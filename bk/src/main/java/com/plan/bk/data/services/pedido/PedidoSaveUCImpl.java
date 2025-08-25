package com.plan.bk.data.services.pedido;

import com.plan.bk.data.entity.*;
import com.plan.bk.data.repository.ClienteRepository;
import com.plan.bk.data.repository.PedidoRepository;
import com.plan.bk.data.repository.ProductoRepository;
import com.plan.bk.data.services.pedido.uc.PedidoSaveUC;
import com.plan.bk.dto.PedidoDetalleDto;
import com.plan.bk.dto.PedidoDto;
import com.plan.bk.mapper.PedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PedidoSaveUCImpl implements PedidoSaveUC {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;

    @Transactional
    @Override
    public Optional<PedidoDto> savePedido(PedidoDto pedido) {

        Pedido pedidoNew= new Pedido();

        pedidoNew.setFecha(pedido.getFecha());

        pedidoNew.setTotal(pedido.getTotal());


        pedidoNew.setCliente(getCliente(pedido.getIdCliente()));


        pedidoNew.setDetalle(pedido.getDetalle()
                .stream()
                .map(det -> mapperDetalle(det, pedidoNew))
                .collect(Collectors.toList()));

        Pedido pedidoSave= repository.save(pedidoNew);

        return Optional.of(PedidoMapper.toDto(pedidoSave));

    }

    private PedidoDet mapperDetalle(PedidoDetalleDto det, Pedido pedidoNew) {

        PedidoDet pedidoDetNew = new PedidoDet();
        pedidoDetNew.setPk(new PedidoDetPk());
        pedidoDetNew.getPk().setItem(det.getItem());
        pedidoDetNew.setPedido(pedidoNew);
        pedidoDetNew.setProducto(getProducto(det.getIdProducto()));
        pedidoDetNew.setCantidad(det.getCantidad());
        pedidoDetNew.setPrecioUnitario(det.getPrecioUnitario());
        pedidoDetNew.setPrecioSubTotal(det.getSubTotal());

        return pedidoDetNew;

    }


    private Producto getProducto(long idProducto) {
        return productoRepository.findById(idProducto).orElseThrow(() ->
                new RuntimeException("El producto no existe " + idProducto) );
    }


    private Cliente getCliente(Long idCliente) {
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("El Id del Cliente no existe"));
    }
}
