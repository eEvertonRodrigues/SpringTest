package com.example.SpringTest.database;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository; // Melhor que apenas 'Repository'
import java.util.Optional;

@Entity
public class Person { // Classe deve ser public

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY é o padrão para MySQL/PostgreSQL/H2
    private Long id;
    private String name;

    // O JPA exige um construtor vazio (default constructor)
    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
