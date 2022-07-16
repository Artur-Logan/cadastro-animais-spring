package com.artur.cadastroanimais.services;

import com.artur.cadastroanimais.dto.request.AnimalRequest;
import com.artur.cadastroanimais.dto.response.AnimalResponse;
import com.artur.cadastroanimais.entities.Animal;
import com.artur.cadastroanimais.exceptions.AnimalNotFoundException;
import com.artur.cadastroanimais.mappers.MapperAnimal;
import com.artur.cadastroanimais.repositories.AnimalRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final MapperAnimal mapperAnimal;
    private final AnimalRespository animalRespository;

    public AnimalResponse criar(AnimalRequest animalRequest){
        Animal animal = mapperAnimal.toEntity(animalRequest);

        animalRespository.save(animal);

        return mapperAnimal.toResponse(animal);
    }

    public AnimalResponse obter(Long id){
        Animal animal = animalRespository.findById(id).orElse(null);

        if(animal == null){
            throw new AnimalNotFoundException("Animal não foi encontrado no banco de dados.");
        }

        return mapperAnimal.toResponse(animal);
    }

    public List<AnimalResponse> listarTodos(){
        List<Animal>  animalResponses = animalRespository.findAll();

        return animalResponses.
                stream().
                map( animal -> mapperAnimal.toResponse(animal))
                .collect(Collectors.toList());

    }

    public void deletar(Long id){
        Animal animal = animalRespository.findById(id).get();
        animalRespository.delete(animal);
    }

    public AnimalResponse att(Long id , AnimalRequest animalRequest){
        Animal animal = animalRespository.findById(id).orElse(null);

        if(animal == null){
            throw new AnimalNotFoundException("Animal não foi encontrado no banco de dados.");
        }

        mapperAnimal.att(animalRequest, animal);

        return mapperAnimal.toResponse(animal);
    }
}

