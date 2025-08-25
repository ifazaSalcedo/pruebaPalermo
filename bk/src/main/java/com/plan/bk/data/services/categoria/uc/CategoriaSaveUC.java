package com.plan.bk.data.services.categoria.uc;

import com.plan.bk.dto.CategoriaDto;

import java.util.Optional;

public interface CategoriaSaveUC {
    public Optional<CategoriaDto> saveCategoria(CategoriaDto categoria);
}
