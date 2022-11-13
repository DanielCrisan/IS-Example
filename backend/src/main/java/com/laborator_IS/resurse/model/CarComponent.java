package com.laborator_IS.resurse.model;

import com.laborator_IS.resurse.constants.ComponentType;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CarComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private ComponentType type;
    private Long price;
    private String color;

}
