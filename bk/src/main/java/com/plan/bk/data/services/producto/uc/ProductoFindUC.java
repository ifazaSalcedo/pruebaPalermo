package com.plan.bk.data.services.producto.uc;

import com.plan.bk.dto.ProductoDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductoFindUC {
    Optional<ProductoDto> findById(Long id);
    Optional<ProductoDto> findByCodigoBarra(String codigoBarras);
    Page<ProductoDto> findAll(int page, int size);
}
