package de.volkswagen.enclosure;

public class EnclosureNotFoundException extends RuntimeException {
    public EnclosureNotFoundException(Long enclosureId) {
        super("Enclosure with id " + enclosureId + " not found");
    }
}
