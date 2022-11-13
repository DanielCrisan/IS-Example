package com.laborator_IS.resurse.mapper;

import com.laborator_IS.resurse.exceptions.ApiExceptionResponse;
import com.laborator_IS.resurse.dto.OwnerDetailsDTO;
import com.laborator_IS.resurse.model.Owner;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OwnerMapper {

    public static List<OwnerDetailsDTO> mapOwnerToDetails(List<Owner> owners) throws ApiExceptionResponse {
      List<OwnerDetailsDTO> dtos=new LinkedList<>();
      for(Owner owner:owners){
          if(owner.getContact()==null){
              throw ApiExceptionResponse.builder().status(HttpStatus.NOT_FOUND).message("No contact for owner: "+owner.getName()).errors(Collections.singletonList("error.email.not_found")).build();
          }
          dtos.add(OwnerDetailsDTO.builder().name(owner.getName()).email(owner.getContact().getEmail()).street(owner.getAddress().getStreet()).build());
      }
      return dtos;
    }
}
