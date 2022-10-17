package com.classregistry.classregistryapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
@Builder
@Getter
@Setter
public final class TemaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
}
