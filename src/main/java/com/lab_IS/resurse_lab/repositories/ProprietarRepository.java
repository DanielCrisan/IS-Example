package com.lab_IS.resurse_lab.repositories;

import com.lab_IS.resurse_lab.models.Proprietar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarRepository extends CrudRepository<Proprietar, Long> {
}
