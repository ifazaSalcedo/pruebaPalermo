package com.plan.bk.data.services.producto.uc;

import com.plan.bk.dto.ProductoDto;

import java.util.Optional;

public interface ProductoSaveUC {
    public Optional<ProductoDto> save(ProductoDto producto);

}
