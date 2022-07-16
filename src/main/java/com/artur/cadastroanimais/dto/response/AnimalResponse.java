package com.artur.cadastroanimais.dto.response;

import lombok.Data;

@Data
public class AnimalResponse {

    private Long id;
    private String nomeAnimal;
    private String raca;
//    private LocalDate dataNascimento;
    private String nomeDono;
    private String sobrenomeDono;
    private String telefoneDono;
}
