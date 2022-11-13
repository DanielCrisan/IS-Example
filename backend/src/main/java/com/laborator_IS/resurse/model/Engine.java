package com.laborator_IS.resurse.model;

import com.laborator_IS.resurse.constants.MotorType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Engine{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long horsePower;
    private MotorType type;

}
