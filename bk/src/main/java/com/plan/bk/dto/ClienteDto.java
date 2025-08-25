package com.plan.bk.dto;

import lombok.Data;
import lombok.Value;

@Value
public class ClienteDto {
    Long codigo;
    String documento;
    String nombre;
}
