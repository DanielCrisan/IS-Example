package com.lab_IS.resurse_lab.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Claxon extends Componenta {
    private String culoare;
}
