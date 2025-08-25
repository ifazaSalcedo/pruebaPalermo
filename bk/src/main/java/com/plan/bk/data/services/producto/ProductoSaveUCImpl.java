package com.plan.bk.data.services.producto;

import com.plan.bk.data.entity.Producto;
import com.plan.bk.data.repository.ProductoRepository;
import com.plan.bk.data.services.producto.uc.ProductoSaveUC;
import com.plan.bk.dto.ProductoDto;
import com.plan.bk.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.plan.bk.mapper.ProductoMapper.toEntity;

@RequiredArgsConstructor
@Service
public class ProductoSaveUCImpl implements ProductoSaveUC {

    private final ProductoRepository repository;

    @Override
    public Optional<ProductoDto> save(ProductoDto producto) {
        Producto productoSave = repository.save(ProductoMapper.toEntity(producto));
        return Optional.of(ProductoMapper.toDto(productoSave));
    }

}
