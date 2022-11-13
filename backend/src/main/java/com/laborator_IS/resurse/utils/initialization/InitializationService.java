package com.laborator_IS.resurse.utils.initialization;

import com.laborator_IS.resurse.model.Address;
import com.laborator_IS.resurse.model.Contact;
import com.laborator_IS.resurse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitializationService {

    @Autowired
    private MockDataRepo mockDataRepo;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Bean
    public void initializeData(){
        List<Address> addresses= (List<Address>) addressRepository.saveAll(mockDataRepo.initAddress());
        List<Contact> contacts=(List<Contact>) contactRepository.saveAll(mockDataRepo.initContact());
        engineRepository.saveAll(mockDataRepo.initEngines());
        componentRepository.saveAll(mockDataRepo.initCarComponents());
        carRepository.saveAll(mockDataRepo.initCars());
        ownerRepository.saveAll(mockDataRepo.initOwners(addresses,contacts));
    }
}
