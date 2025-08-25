package com.plan.bk.data.services.cliente;

import com.plan.bk.data.entity.Cliente;
import com.plan.bk.data.repository.ClienteRepository;
import com.plan.bk.data.services.cliente.uc.ClienteFindUCService;
import com.plan.bk.dto.ClienteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.plan.bk.mapper.ClienteMapper.toDto;

@RequiredArgsConstructor
@Service
public class ClienteFindByImpl implements ClienteFindUCService {

    private final ClienteRepository repository;

    @Override
    public Optional<ClienteDto> findByIdCliente(Long id) {

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("El Id del cliete que busca no existe!"));

        return Optional.of(toDto(cliente));
    }

    @Override
    public Optional<ClienteDto> findByDocumentoCliente(String documento) {
        Cliente cliente = repository.findByDocumento(documento)
                .orElseThrow(() -> new RuntimeException("El Documento del cliete que busca no existe!"));

        return Optional.of(toDto(cliente));
    }

    @Override
    public List<ClienteDto> findAllCliente() {
        return List.of();
    }
}
