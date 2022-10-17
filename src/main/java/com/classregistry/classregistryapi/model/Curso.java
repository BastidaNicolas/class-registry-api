package com.classregistry.classregistryapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String tipo;
    private Date fecha_finalizacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<Tema> temas;

}
