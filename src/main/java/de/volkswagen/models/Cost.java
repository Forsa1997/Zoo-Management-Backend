package de.volkswagen.models;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    private long monthlyCost;



    public Cost() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost = (Cost) o;
        return monthlyCost == cost.monthlyCost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthlyCost);
    }

    public Cost(long monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public static Cost add(Cost cost1, Cost cost2) {
        
        return new Cost(cost1.monthlyCost + cost2.monthlyCost);
    }


    public long getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(long monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

}
