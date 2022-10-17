package com.classregistry.classregistryapi.controller;

import com.classregistry.classregistryapi.dto.CursoDTO;
import com.classregistry.classregistryapi.dto.CursoTemasDTO;
import com.classregistry.classregistryapi.model.Curso;
import com.classregistry.classregistryapi.service.ICursoDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CursoDTOController {

    @Autowired
    private ICursoDTOService interCursoDTO;

    @GetMapping("/cursos")
    public List<CursoDTO> getCursos(){
        return ((List<Curso>) interCursoDTO.findAll())
                .stream().map(curso -> {
                    return CursoDTO.from(curso);
                }).collect(Collectors.toList());
    }

    @GetMapping("/cursos/search")
    public List<CursoDTO> getCurso(@RequestParam String nombre){
        return ((List<Curso>) interCursoDTO.getCurso(nombre))
                .stream().map(curso -> {
                    return CursoDTO.from(curso);
                }).collect(Collectors.toList());
    }

    @GetMapping("/cursos/{id}/temas")
    public CursoTemasDTO getTemas(@PathVariable Long id){
        return CursoTemasDTO.from(interCursoDTO.findTemasDeCurso(id));
    }
}
