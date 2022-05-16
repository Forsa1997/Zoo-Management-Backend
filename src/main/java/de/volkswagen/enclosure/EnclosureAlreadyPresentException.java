package de.volkswagen.enclosure;

public class EnclosureAlreadyPresentException extends RuntimeException {
    public EnclosureAlreadyPresentException(Long enclosureId) {
        super("Enclosure with id " + enclosureId + " already exists");
    }
}
