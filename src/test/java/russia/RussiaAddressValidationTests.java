package russia;

import org.example.russia.RussiaAddressValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RussiaAddressValidationTests {

    private static final String VALID_ADDRESS = "г. Воронеж, ул. Урывского д. 5";
    private static final String INVALID_ADDRESS = "г. Boston, ул. Урывского д. 5";


    @Test
    public void givenValidAddress_whenValidate_AddressValid(){
        RussiaAddressValidation russiaAddressValidation = new RussiaAddressValidation();
        boolean isValid = russiaAddressValidation.validate(VALID_ADDRESS);
        assertTrue(isValid);
    }

    @Test
    public void givenInvalidAddress_whenValidate_addressInvalid(){
        RussiaAddressValidation russiaAddressValidation = new RussiaAddressValidation();
        boolean isValid = russiaAddressValidation.validate(INVALID_ADDRESS);
        assertFalse(isValid);
    }
}
