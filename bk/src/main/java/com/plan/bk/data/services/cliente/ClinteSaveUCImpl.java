package com.plan.bk.data.services.cliente;

import com.plan.bk.data.entity.Cliente;
import com.plan.bk.data.repository.ClienteRepository;
import com.plan.bk.data.services.cliente.uc.ClienteSaveUCService;
import com.plan.bk.dto.ClienteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.plan.bk.mapper.ClienteMapper.toDto;
import static com.plan.bk.mapper.ClienteMapper.toEntity;

@RequiredArgsConstructor
@Service
public class ClinteSaveUCImpl implements ClienteSaveUCService {

    private final ClienteRepository repository;


    @Override
    public Optional<ClienteDto> saveCliente(ClienteDto cliente) {

        Cliente clieteSave = repository.save(toEntity(cliente));

        return Optional.of(toDto(clieteSave));

    }

}
