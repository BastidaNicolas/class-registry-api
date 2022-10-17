package com.classregistry.classregistryapi.dto;

import com.classregistry.classregistryapi.model.Curso;
import com.classregistry.classregistryapi.model.Tema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class CursoDTO {

    private Long id;
    private String nombre;
    private String tipo;
    private Date fecha_finalizacion;
    private List<TemaDTO> temas;

    public static CursoDTO from (Curso curso){
        return CursoDTO.builder()
                .id(curso.getId())
                .nombre(curso.getNombre())
                .tipo(curso.getTipo())
                .fecha_finalizacion(curso.getFecha_finalizacion())
                .temas(from(curso.getTemas()))
                .build();
    }

    public static List<TemaDTO> from (List<Tema> temas){
        return temas.stream().map(t -> TemaDTO.builder()
                .id(t.getId())
                .nombre(t.getNombre())
                .descripcion(t.getDescripcion())
                .build()).collect(Collectors.toList());
    }
}
