package de.volkswagen.animal;

import de.volkswagen.models.Cost;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private Long id = -1L;

    private String name = "";
    private AnimalType animalType = AnimalType.UNDEFINED;

    @OneToOne
    private Cost cost = new Cost();
}
