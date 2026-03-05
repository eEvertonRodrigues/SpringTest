package com.example.SpringTest.services;

import com.example.SpringTest.database.Car;

public interface ICarService {
    Car salvarCarro(String model, Integer year);
    Boolean alugarCarro(Long carId, Long personId);
    Iterable<Car> listarTodos();
} 