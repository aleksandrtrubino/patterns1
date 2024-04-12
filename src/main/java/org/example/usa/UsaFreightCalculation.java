package org.example.us;

import org.example.basic.FreightCalculation;

public class UsaFreightCalculation implements FreightCalculation {

    private static final double COST = 200000;

    @Override
    public double calculate(int weightInTons) {
        return weightInTons * COST;
    }
}
