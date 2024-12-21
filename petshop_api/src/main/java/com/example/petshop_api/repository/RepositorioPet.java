package com.example.petshop_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petshop_api.model.Pet;
@Repository
public interface RepositorioPet extends CrudRepository<Pet, Integer> {

    @SuppressWarnings("null")
    List<Pet> findAll();
    Pet findByid(int id);
    List<Pet> findByNome(String nome);
    int countByid(int id);
    
    
    @Query(value = "SELECT * FROM pets WHERE tipo_animal = :animal", nativeQuery = true)
    List<Pet> animal(String animal);

}
