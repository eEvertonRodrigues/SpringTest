package com.example.SpringTest.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.SpringTest.database.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
    // Você só escreve métodos aqui se forem consultas customizadas
    // Ex: List<Person> findByName(String name);
}