package com.lab_IS.resurse_lab.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Masina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String marca;

    @OneToMany (cascade = CascadeType.REMOVE)
    private List<Componenta> componente;

    @ManyToOne
    private Proprietar proprietar;
}
