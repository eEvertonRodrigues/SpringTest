package com.example.SpringTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringTest.database.Car;
import com.example.SpringTest.services.ICarService;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private ICarService service;

    @PostMapping("/salvar")
    public Car salvarCarro(String model, Integer year){
        return service.salvarCarro(model, year);
    }

    @PostMapping("/alugar")
    public Boolean alugarCarro(Long carId, Long personId){
        return service.alugarCarro(carId, personId);
    }

    @GetMapping("/listar-todos")
    public Iterable<Car> listarTodos(){
        return service.listarTodos();
    }
}