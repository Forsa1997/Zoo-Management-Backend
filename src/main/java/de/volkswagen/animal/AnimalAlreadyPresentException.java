package de.volkswagen.animal;

public class AnimalAlreadyPresentException extends RuntimeException {
    public AnimalAlreadyPresentException(Long animalId) {
        super("Animal with id " + animalId + " already present");
    }
}
