package de.volkswagen.staff;

public class StaffAlreadyPresentException extends RuntimeException {
    public StaffAlreadyPresentException(Long staffId) {
        super("Staff with id " + staffId + " already exists");
    }
}
