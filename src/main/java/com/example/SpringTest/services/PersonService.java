package com.example.SpringTest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SpringTest.database.Person;
import com.example.SpringTest.repository.PersonRepository;

@Service
public class PersonService implements IPersonService {

    @Autowired // O Spring injeta o Repository aqui
    private PersonRepository repository;

    @Override
    public Person salvar(String nome) {
        return repository.save(new Person(nome));
    }

    @Override
    public Iterable<Person> listarTodos() {
        return repository.findAll();
    }
}