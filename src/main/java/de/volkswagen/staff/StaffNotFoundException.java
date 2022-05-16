package de.volkswagen.staff;

public class StaffNotFoundException extends RuntimeException {
    public StaffNotFoundException(Long staffId) {
        super("Staff with id " + staffId + " not found");
    }
}
