package com.artur.cadastroanimais.controllers;

import com.artur.cadastroanimais.dto.request.AnimalRequest;
import com.artur.cadastroanimais.dto.response.AnimalResponse;
import com.artur.cadastroanimais.entities.Animal;
import com.artur.cadastroanimais.services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalResponse> criar(@RequestBody AnimalRequest animalRequest){
        AnimalResponse animalResponse = animalService.criar(animalRequest);

        return ResponseEntity.ok(animalResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> att(@PathVariable Long id,@RequestBody AnimalRequest animalRequest){
        AnimalResponse animalResponse = animalService.att(id, animalRequest);

        return ResponseEntity.ok().body(animalResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        animalService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponse>> listar(){
        List<AnimalResponse> animalResponses = animalService.listarTodos();

        return ResponseEntity.ok().body(animalResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponse> obter(@PathVariable Long id){
        AnimalResponse animalResponse = animalService.obter(id);

        return ResponseEntity.ok().body(animalResponse);
    }
}
