package com.plan.bk.data.services.producto.uc;

import com.plan.bk.dto.ProductoDto;
import com.plan.bk.dto.dtopage.PageBasicResponse;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductoFindUC {
    Optional<ProductoDto> findById(Long id);
    Optional<ProductoDto> findByCodigoBarra(String codigoBarras);
    PageBasicResponse<ProductoDto> findAll(int page, int size);
}
