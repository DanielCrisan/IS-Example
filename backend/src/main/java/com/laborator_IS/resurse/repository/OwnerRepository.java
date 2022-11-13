package com.laborator_IS.resurse.repository;

import com.laborator_IS.resurse.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findFirstByName(String name);
}
