package russia;

import org.example.russia.RussiaTaxCalculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RussiaTaxCalculationTests {

    private static final double SUM = 1000;
    private static final double EXPECTED_TAX = 130;

    @Test
    public void givenSum_whenTaxCalculated_taxReturned(){
        RussiaTaxCalculation russiaTaxCalculation = new RussiaTaxCalculation();
        double tax = russiaTaxCalculation.calculate(SUM);
        assertEquals(EXPECTED_TAX, tax);
    }
}
