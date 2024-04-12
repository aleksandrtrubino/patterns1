package russia;

import org.example.russia.RussiaFreightCalculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RussiaFreightCalculationTests {

    private static final int TONS = 10;
    private static final double EXPECTED_FREIGHT = 1000000;

    @Test
    public void givenTons_whenFreightCalculated_freightReturned(){
        RussiaFreightCalculation russiaFreightCalculation = new RussiaFreightCalculation();
        double freight = russiaFreightCalculation.calculate(TONS);
        assertEquals(EXPECTED_FREIGHT, freight);
    }
}
