package com.example.SpringTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringTest.database.Person;
import com.example.SpringTest.services.IPersonService;

@RestController
@RequestMapping("/persons") // Todas as URLs aqui começam com /persons
public class PersonController {

    @Autowired
    private IPersonService service;

    @PostMapping
    public Person criar(@RequestParam String nome) {
        return service.salvar(nome);
    }

    @GetMapping
    public Iterable<Person> listar() {
        return service.listarTodos();
    }
}