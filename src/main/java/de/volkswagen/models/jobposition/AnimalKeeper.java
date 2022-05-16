package de.volkswagen.models.jobposition;

import de.volkswagen.enclosure.Enclosure;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;


@Entity
public class AnimalKeeper extends JobPositionComponent {
    @ManyToMany
    private List<Enclosure> enclosures;
}
