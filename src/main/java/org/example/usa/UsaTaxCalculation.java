package org.example.us;

import org.example.basic.TaxCalculation;

public class UsaTaxCalculation implements TaxCalculation {

    private static final double TAX = 0.3;

    @Override
    public double calculate(double sumInDollars) {
        return sumInDollars * TAX;
    }
}
