package com.laborator_IS.resurse.controller;

import com.laborator_IS.resurse.exceptions.ApiExceptionResponse;
import com.laborator_IS.resurse.dto.OwnerCarAdditionDTO;
import com.laborator_IS.resurse.model.Owner;
import com.laborator_IS.resurse.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
@CrossOrigin(origins = "http://localhost:4200")
public class OwnerController {

    @Autowired
    public OwnerService ownerService;

    @GetMapping
    public ResponseEntity findAllOwners(){
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.findAll());
    }

    @PostMapping
    public ResponseEntity saveNewOwner(@RequestBody Owner owner){
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.save(owner));
    }

    @GetMapping("/{name}")
    public ResponseEntity findOwnerByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.findByName(name));
    }

    @PutMapping
    public ResponseEntity updateOwnersCars(@RequestBody OwnerCarAdditionDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.updateCars(dto));
    }

    @GetMapping("/details")
    public ResponseEntity findOwnerDetails() throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.findOwnerDetails());
    }

}
