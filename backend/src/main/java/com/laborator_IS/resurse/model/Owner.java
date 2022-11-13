package com.laborator_IS.resurse.model;

import lombok.*;


import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(inverseJoinColumns=@JoinColumn(name="car_id"))
    private List<Car> cars;

    @OneToOne
    @JoinColumn(name="address_id",referencedColumnName = "id")
    private Address address;

    @OneToOne
    @JoinColumn(name="contact_id", referencedColumnName = "id")
    private Contact contact;

}
