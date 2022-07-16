package com.artur.cadastroanimais.repositories;

import com.artur.cadastroanimais.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRespository extends JpaRepository<Animal, Long> {
}
