package de.volkswagen.animal;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AnimalList {
    private List<Animal> animals;

    public AnimalList() {
        this.animals = new ArrayList<>();
    }

    public AnimalList(List<Animal> animals) {
        this.animals = animals;
        if (this.animals == null) {
            this.animals = new ArrayList<>();
        }
    }
}
