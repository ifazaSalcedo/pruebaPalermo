package com.plan.bk.mapper;

import com.plan.bk.data.entity.Categoria;
import com.plan.bk.dto.CategoriaDto;

public class CategoriaMapper {
    public static CategoriaDto toDto(Categoria categoria){
        return new CategoriaDto(categoria.getCodigo(), categoria.getDescripcion());
    }
    public static Categoria toEntity(CategoriaDto categoria){
        return new Categoria(categoria.getCodigo(), categoria.getDescripcion());
    }
}
