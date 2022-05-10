package de.volkswagen.animal;

import de.volkswagen.models.Cost;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    private String name;
    private AnimalType animalType;
    private Cost cost;


    public Cost getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }
}
