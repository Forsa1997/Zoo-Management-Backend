package de.volkswagen.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long monthlyCost;

    public Cost(long monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public static Cost add(Cost cost1, Cost cost2) {
        return new Cost(cost1.monthlyCost + cost2.monthlyCost);
    }
}
