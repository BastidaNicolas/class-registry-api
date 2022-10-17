package com.classregistry.classregistryapi.service;

import com.classregistry.classregistryapi.model.Curso;
import com.classregistry.classregistryapi.repository.CursoRepository;
import com.classregistry.classregistryapi.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CursoDTOSercvice  implements ICursoDTOService{

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TemaRepository temaRepository;

    @Override
    public List<Curso> getCurso(String name) {
        return cursoRepository.findByNombreContaining(name);
    }

    @Override
    public Object findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findTemasDeCurso(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }
}
