package com.laborator_IS.resurse.model;

import com.laborator_IS.resurse.utils.MasinaEventListener;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@EntityListeners(MasinaEventListener.class)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String maker;

    @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinTable(inverseJoinColumns=@JoinColumn(name="component_id"))
    private List<CarComponent> components;

    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Engine engine;

}
