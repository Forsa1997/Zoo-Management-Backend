package de.volkswagen.models;

public class Cost {

    private long monthlyCost;


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
