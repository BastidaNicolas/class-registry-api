package com.classregistry.classregistryapi.controller;

import com.classregistry.classregistryapi.dto.TemaDTO;
import com.classregistry.classregistryapi.model.Curso;
import com.classregistry.classregistryapi.model.Tema;
import com.classregistry.classregistryapi.service.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
public class TemaController {

    @Autowired
    private ITemaService interTema;

    @GetMapping("/temas/traer")
    public List<Tema> getAll(){
        List<Tema> temas = interTema.getAll();
        return temas;
    }

    @GetMapping("/temas/traer/{id}")
    public Tema getTema(@PathVariable Long id){
        return interTema.getTema(id);
    }

    @PostMapping("/tema/crear")
    public String create(@RequestBody Tema tema){
        interTema.create(tema);
        return "Tema creado";
    }

    @PutMapping("/tema/editar/{id}")
    public String edit(
            @PathVariable Long id,
            @RequestBody Tema tema
    ){
        Tema newTema = interTema.getTema(id);
        newTema.setNombre(tema.getNombre());
        newTema.setDescripcion(tema.getDescripcion());
        newTema.setCurso(tema.getCurso());
        interTema.create(newTema);
        return "Tema editado";
    }

    @DeleteMapping("/tema/eliminar/{id}")
    public String delete(@PathVariable Long id){
        interTema.delete(id);
        return "Tema eliminado";
    }

}
