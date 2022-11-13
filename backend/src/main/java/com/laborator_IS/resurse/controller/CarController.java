package com.laborator_IS.resurse.controller;

import com.laborator_IS.resurse.dto.GetByManufacturerDTO;
import com.laborator_IS.resurse.exceptions.ApiExceptionResponse;
import com.laborator_IS.resurse.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping()
    public ResponseEntity findAllCars(){
        return ResponseEntity.status(HttpStatus.OK).body(carService.findAll());
    }

    @GetMapping("/{marca}")
    public ResponseEntity findCarByManuf(@PathVariable String marca) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(carService.findByMarca(marca));
    }

    @GetMapping("/{id}/{marca}")
    public ResponseEntity findCarByIdAndManuf(@PathVariable Long id, @PathVariable String marca) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(carService.findFirstByIdAndMarca(id,marca));
    }

    @GetMapping("/find")
    public ResponseEntity findByManufReqParam(@RequestBody GetByManufacturerDTO getByManufacturerDTO) throws ApiExceptionResponse{
        return ResponseEntity.status(HttpStatus.OK).body(carService.findByMarca(getByManufacturerDTO.getMarca()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(carService.deleteCar(id));
    }
}
