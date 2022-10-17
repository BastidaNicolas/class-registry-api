package com.classregistry.classregistryapi.service;

import com.classregistry.classregistryapi.model.Curso;
import com.classregistry.classregistryapi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements ICursoService{

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void create(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public List<Curso> getAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso getCurso(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}
