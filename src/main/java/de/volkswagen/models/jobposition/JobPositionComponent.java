package de.volkswagen.models.jobposition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.volkswagen.staff.Staff;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "jobpositioncomponent")
@JsonIgnoreProperties({"staff"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JobPositionComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Staff.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private Staff owner;
}
