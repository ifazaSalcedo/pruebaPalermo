package com.plan.bk.data.services.categoria;

import com.plan.bk.data.entity.Categoria;
import com.plan.bk.data.repository.CategoriaRepository;
import com.plan.bk.data.services.categoria.uc.CategoriaFindUC;
import com.plan.bk.dto.CategoriaDto;
import com.plan.bk.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class CategoriaFindUCImpl implements CategoriaFindUC {

    private final CategoriaRepository repository;


    @Override
    public Optional<CategoriaDto> findById(Long id) {
        Categoria categoriadb= repository.findById(id)
                .orElseThrow(() -> new RuntimeException("La categoria ingresada no existe " + id));
        return Optional.of(CategoriaMapper.toDto(categoriadb));
    }

    @Override
    public List<CategoriaDto> findAll() {
        List<Categoria> listdb = repository.findAll();

        return listdb.stream()
                .map(CategoriaMapper::toDto)
                .collect(Collectors.toList());

    }
}
