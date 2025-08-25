package com.plan.bk.data.services.cliente.uc;

import com.plan.bk.dto.ClienteDto;

import java.util.Optional;

public interface ClienteSaveUCService {
    Optional<ClienteDto> saveCliente(ClienteDto cliente);
}
