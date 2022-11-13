package com.laborator_IS.resurse.service;

import com.laborator_IS.resurse.exceptions.ApiExceptionResponse;
import com.laborator_IS.resurse.dto.OwnerCarAdditionDTO;
import com.laborator_IS.resurse.dto.OwnerDetailsDTO;
import com.laborator_IS.resurse.model.Owner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OwnerService {
    List<Owner> findAll();
    Owner save(Owner owner);
    Owner updateCars(OwnerCarAdditionDTO dto);
    Owner findByName(String name);
    List<OwnerDetailsDTO> findOwnerDetails() throws ApiExceptionResponse;
}
