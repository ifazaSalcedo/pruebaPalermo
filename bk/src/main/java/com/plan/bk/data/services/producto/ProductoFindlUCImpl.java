package com.plan.bk.data.services.producto;

import com.plan.bk.data.entity.Producto;
import com.plan.bk.data.repository.ProductoRepository;
import com.plan.bk.data.services.producto.uc.ProductoFindUC;
import com.plan.bk.dto.ProductoDto;
import com.plan.bk.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductoFindlUCImpl implements ProductoFindUC {

    private final ProductoRepository repository;

    @Override
    public Optional<ProductoDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductoDto> findByCodigoBarra(String codigoBarras) {
        return Optional.empty();
    }

    @Override
    public Page<ProductoDto> findAll(int page, int size) {
        Page<Producto> listdb = repository.allProductoListaPrecios(PageRequest.of(page, size));
        return listdb.map(ProductoMapper::toDto);
    }
}
