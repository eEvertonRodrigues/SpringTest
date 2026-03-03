package com.example.SpringTest.services;

import com.example.SpringTest.database.Person;

public interface IPersonService {
    Person salvar(String nome);
    Iterable<Person> listarTodos();
}