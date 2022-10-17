package com.classregistry.classregistryapi.controller;

import com.classregistry.classregistryapi.model.Curso;
import com.classregistry.classregistryapi.model.Tema;
import com.classregistry.classregistryapi.repository.CursoRepository;
import com.classregistry.classregistryapi.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private ICursoService interCurso;

    @PostMapping("/cursos/crear")
    public String create(@RequestBody Curso curso){
        interCurso.create(curso);
        return "Curso creado";
    }

    @GetMapping("/cursos/traer")
    public List<Curso> getAll(){
        List<Curso> cursos = interCurso.getAll();
        return cursos;
    }

    @DeleteMapping("/cursos/eliminar/{id}")
    public String delete(@PathVariable Long id){
        interCurso.delete(id);
        return "Curso eliminado";
    }

    @PutMapping("/curso/editar/{id}")
    public String edit(
            @PathVariable Long id,
            @RequestBody Curso curso
    ){
        Curso editCurso = interCurso.getCurso(id);
        editCurso.setNombre(curso.getNombre());
        editCurso.setTipo(curso.getTipo());
        editCurso.setFecha_finalizacion(curso.getFecha_finalizacion());
        interCurso.create(editCurso);
        return "Curso editado";
    }
}
