package com.artur.cadastroanimais.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeAnimal;
    private String raca;
    private String nomeDono;
    private String sobrenomeDono;
    private String telefoneDono;
}