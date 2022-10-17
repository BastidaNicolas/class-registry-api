package com.classregistry.classregistryapi.service;

import com.classregistry.classregistryapi.model.Tema;

import java.util.List;

public interface ITemaService {
    List<Tema> getAll();

    Tema getTema(Long id);

    void create(Tema tema);

    void delete(Long id);
}
