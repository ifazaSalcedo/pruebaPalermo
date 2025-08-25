package com.plan.bk.data.services.cliente.uc;

import com.plan.bk.dto.ClienteDto;

import java.util.List;
import java.util.Optional;

public interface ClienteFindUCService {
    public Optional<ClienteDto> findByIdCliente(Long id);
    public Optional<ClienteDto> findByDocumentoCliente(String id);
    public List<ClienteDto> findAllCliente();
}
