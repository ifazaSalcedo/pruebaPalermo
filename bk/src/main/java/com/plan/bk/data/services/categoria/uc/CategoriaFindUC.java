package com.plan.bk.data.services.categoria.uc;

import com.plan.bk.dto.CategoriaDto;

import java.util.List;
import java.util.Optional;

public interface CategoriaFindUC {
    Optional<CategoriaDto> findById(Long id);
    List<CategoriaDto> findAll();
}
