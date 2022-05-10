package de.volkswagen.enclosure;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface EnclosureRepository extends JpaRepository<Enclosure, Long> {
    Enclosure save(Enclosure enclosure);
}
