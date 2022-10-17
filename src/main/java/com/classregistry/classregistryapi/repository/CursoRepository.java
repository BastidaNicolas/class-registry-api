package com.classregistry.classregistryapi.repository;

import com.classregistry.classregistryapi.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNombreContaining(String name);
}
