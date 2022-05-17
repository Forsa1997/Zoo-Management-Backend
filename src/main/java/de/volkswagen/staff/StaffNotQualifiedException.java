package de.volkswagen.staff;

public class StaffNotQualifiedException extends RuntimeException {
    public StaffNotQualifiedException(Long staffId) {
        super("Staff with id " + staffId + " is not qualified for that job position");
    }
}
