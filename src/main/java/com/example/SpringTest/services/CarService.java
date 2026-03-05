package com.example.SpringTest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SpringTest.database.Car;
import com.example.SpringTest.database.Person;
import com.example.SpringTest.repository.CarRepository;
import com.example.SpringTest.repository.PersonRepository;

@Service
public class CarService implements ICarService {
    
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Car salvarCarro(String model, Integer year){
        return carRepository.save(new Car(model, year));
    }

    @Override
    public Boolean alugarCarro(Long carId, Long personId){
        
        Car car = carRepository.findById(carId).get();
        Person person = personRepository.findById(personId).get();

        if(car == null || person == null ){ return false; }
        
        car.setPerson(person);
        carRepository.save(car);

        if(car.getPerson().getId() != person.getId()) { return false; }

        return true;
    }

    @Override
    public Iterable<Car> listarTodos(){
        return carRepository.findAll();
    }
}