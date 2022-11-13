package com.laborator_IS.resurse.service.impl;

import com.laborator_IS.resurse.exceptions.ApiExceptionResponse;
import com.laborator_IS.resurse.repository.CarRepository;
import com.laborator_IS.resurse.repository.OwnerRepository;
import com.laborator_IS.resurse.dto.OwnerCarAdditionDTO;
import com.laborator_IS.resurse.dto.OwnerDetailsDTO;
import com.laborator_IS.resurse.mapper.OwnerMapper;
import com.laborator_IS.resurse.model.Car;
import com.laborator_IS.resurse.model.Owner;
import com.laborator_IS.resurse.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CarRepository carRepository;

    public List<Owner> findAll(){
        return (List<Owner>) ownerRepository.findAll();
        //return owners.stream().peek(owner -> owner.getCars().forEach(car -> car.setOwner(null))).collect(Collectors.toList());
    }

    public Owner save(Owner owner){
        return ownerRepository.save(owner);
    }

    public Owner updateCars(OwnerCarAdditionDTO dto){
        Owner owner=ownerRepository.findById(dto.getOwnerID()).get();
        Car car=carRepository.findById(dto.getCarID()).get();
        owner.getCars().add(car);
        return ownerRepository.save(owner);
    }

    public Owner findByName(String name){
        return ownerRepository.findFirstByName(name);
    }

    public List<OwnerDetailsDTO> findOwnerDetails() throws ApiExceptionResponse {
        return OwnerMapper.mapOwnerToDetails((List<Owner>) ownerRepository.findAll());
    }
}
