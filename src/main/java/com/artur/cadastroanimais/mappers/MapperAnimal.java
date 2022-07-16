package com.artur.cadastroanimais.mappers;

import com.artur.cadastroanimais.dto.request.AnimalRequest;
import com.artur.cadastroanimais.dto.response.AnimalResponse;
import com.artur.cadastroanimais.entities.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperAnimal {

    Animal toEntity(AnimalRequest animalRequest);
    AnimalResponse toResponse(Animal animal);
    Animal att (AnimalRequest animalRequest,@MappingTarget Animal animal);
}
