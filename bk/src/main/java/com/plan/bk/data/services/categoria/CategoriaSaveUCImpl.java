package com.plan.bk.data.services.categoria;

import com.plan.bk.data.entity.Categoria;
import com.plan.bk.data.repository.CategoriaRepository;
import com.plan.bk.data.services.categoria.uc.CategoriaSaveUC;
import com.plan.bk.dto.CategoriaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.plan.bk.mapper.CategoriaMapper.toDto;
import static com.plan.bk.mapper.CategoriaMapper.toEntity;

@RequiredArgsConstructor
@Service
public class CategoriaSaveUCImpl implements CategoriaSaveUC {

    private final CategoriaRepository repository;

    @Override
    public Optional<CategoriaDto> saveCategoria(CategoriaDto categoria) {

        Categoria categoriaSave= repository.save(toEntity(categoria));

        return Optional.of(toDto(categoriaSave));
    }
}
