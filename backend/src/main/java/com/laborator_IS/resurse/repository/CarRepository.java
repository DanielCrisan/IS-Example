package com.laborator_IS.resurse.repository;

import com.laborator_IS.resurse.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
    Car findFirstByMaker(String maker);
    Car findFirstByIdAndMaker(Long id, String maker);
}
