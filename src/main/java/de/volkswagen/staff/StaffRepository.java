package de.volkswagen.staff;

import de.volkswagen.enclosure.Enclosure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff save (Staff staff);
}
