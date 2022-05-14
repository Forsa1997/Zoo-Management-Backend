package de.volkswagen.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cost {

    private long monthlyCost = 0L;

    public static Cost add(Cost cost1, Cost cost2) {
        return new Cost(cost1.monthlyCost + cost2.monthlyCost);
    }
}
