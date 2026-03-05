package com.example.SpringTest.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.SpringTest.database.Car;

public interface CarRepository extends CrudRepository<Car, Long>{

}