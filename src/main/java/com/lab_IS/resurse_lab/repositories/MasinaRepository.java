package com.lab_IS.resurse_lab.repositories;

import com.lab_IS.resurse_lab.models.Masina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasinaRepository extends CrudRepository<Masina, Long> {
    Masina findFirstByMarca(String Marca);
}
