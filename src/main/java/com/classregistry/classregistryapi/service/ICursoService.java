package com.classregistry.classregistryapi.service;

import com.classregistry.classregistryapi.model.Curso;

import java.util.List;

public interface ICursoService {
    void create(Curso curso);

    List<Curso> getAll();

    Curso getCurso(Long id);

    void delete(Long id);
}
