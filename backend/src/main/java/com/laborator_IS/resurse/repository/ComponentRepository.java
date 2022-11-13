package com.laborator_IS.resurse.repository;

import com.laborator_IS.resurse.model.CarComponent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends CrudRepository<CarComponent,Long> {
}
