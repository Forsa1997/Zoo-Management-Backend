package de.volkswagen.staff;

import de.volkswagen.models.Address;
import de.volkswagen.models.BankInfo;
import de.volkswagen.models.jobposition.JobPositionComponent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "staff")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne
    private BankInfo bankInformations;

    @OneToOne
    private Address address;

    @OneToMany(targetEntity = JobPositionComponent.class,
            mappedBy = "owner",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<JobPositionComponent> positions;
}
