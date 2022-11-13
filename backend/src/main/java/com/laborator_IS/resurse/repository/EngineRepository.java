package com.laborator_IS.resurse.repository;

import com.laborator_IS.resurse.model.Engine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends CrudRepository<Engine,Long> {
}
