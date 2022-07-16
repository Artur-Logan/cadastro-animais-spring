package com.artur.cadastroanimais.dto.request;

import lombok.Data;

@Data
public class AnimalRequest {

    private String nomeAnimal;
    private String raca;
    private String nomeDono;
    private String sobrenomeDono;
    private String telefoneDono;
}
