package com.laborator_IS.resurse.service;

import com.laborator_IS.resurse.exceptions.ApiExceptionResponse;
import com.laborator_IS.resurse.model.Car;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {
    Car findByMarca(String marca) throws ApiExceptionResponse;
    Car updateMasina(Car dto);
    List<Car> findAll();
    Car findById(Long id);
    Car findFirstByIdAndMarca(Long id, String marca) throws ApiExceptionResponse;
    Car deleteCar(Long id);
}
