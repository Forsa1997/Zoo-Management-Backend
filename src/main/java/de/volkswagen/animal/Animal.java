package de.volkswagen.animal;

import de.volkswagen.models.Cost;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private String name = "";

    @Builder.Default
    private AnimalType animalType = AnimalType.UNDEFINED;

    @Embedded
    @Builder.Default
    private Cost cost = new Cost();
}
