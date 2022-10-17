package com.classregistry.classregistryapi.dto;

import com.classregistry.classregistryapi.model.Curso;
import com.classregistry.classregistryapi.model.Tema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class CursoTemasDTO {

    private Long idCurso;
    private String nombreCurso;
    private List<TemaDTO> temas;

    public static CursoTemasDTO from (Curso curso){
        return CursoTemasDTO.builder()
                .idCurso(curso.getId())
                .nombreCurso(curso.getNombre())
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
