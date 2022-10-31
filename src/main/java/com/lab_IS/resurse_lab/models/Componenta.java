package com.lab_IS.resurse_lab.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Componenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
