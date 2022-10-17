package com.classregistry.classregistryapi.service;

import com.classregistry.classregistryapi.model.Curso;

import java.util.List;

public interface ICursoDTOService {

    List<Curso> getCurso(String name);

    Object findAll();

    Curso findTemasDeCurso(Long id);
}
