package com.laborator_IS.resurse.service.impl;

import com.laborator_IS.resurse.exceptions.ApiExceptionResponse;
import com.laborator_IS.resurse.repository.CarRepository;
import com.laborator_IS.resurse.model.Car;
import com.laborator_IS.resurse.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    public Car findByMarca(String marca) throws ApiExceptionResponse {

        Car car =carRepository.findFirstByMaker(marca);
        if(car ==null){
            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Nicio masina cu marca "+ marca))
                    .message("Entity not found").status(HttpStatus.NOT_FOUND).build();
        }

        return car;
    }

    public Car updateMasina(Car dto){
        Car persistedCar=carRepository.findById(dto.getId()).get();
        carRepository.save(persistedCar);
        return persistedCar;
    }

    public List<Car> findAll(){
        List<Car> cars=(List<Car>)carRepository.findAll();
        return cars;
    }

    public Car findById(Long id){
        return carRepository.findById(id).get();
    }

    public Car findFirstByIdAndMarca(Long id, String marca) throws ApiExceptionResponse{
        Car car = carRepository.findFirstByIdAndMaker(id,marca);
        if(car ==null){
            ArrayList<String> errors=new ArrayList<>();
            errors.add("Might not exist with maker "+marca);
            errors.add("Might not exist with id "+id);
            errors.add("Might not find by the pair provided");
            throw ApiExceptionResponse.builder().errors(errors)
                    .message("Entity not found").status(HttpStatus.NOT_FOUND).build();
        }

        return car;
    }

    public Car deleteCar(Long id){
        Car car=carRepository.findById(id).get();
        carRepository.delete(car);
        return car;
    }
}
