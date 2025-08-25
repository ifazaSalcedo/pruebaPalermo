package com.plan.bk.mapper;

import com.plan.bk.data.entity.Cliente;
import com.plan.bk.dto.ClienteDto;

public class ClienteMapper {
    public static ClienteDto toDto(Cliente cliente){
        return new ClienteDto(cliente.getCodigo(), cliente.getDocumento(), cliente.getNombre());
    }
    public static Cliente toEntity(ClienteDto cliente){
        return new Cliente(cliente.getCodigo(), cliente.getDocumento(), cliente.getNombre());
    }
}
