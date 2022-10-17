package com.classregistry.classregistryapi.service;

import com.classregistry.classregistryapi.model.Tema;
import com.classregistry.classregistryapi.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService implements ITemaService {

    @Autowired
    private TemaRepository temaRepository;

    @Override
    public List<Tema> getAll() {
        return temaRepository.findAll();
    }

    @Override
    public Tema getTema(Long id) {
        return temaRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Tema tema) {
        temaRepository.save(tema);
    }

    @Override
    public void delete(Long id) {
        temaRepository.deleteById(id);
    }
}
