package org.example.us;

import org.example.basic.AbstractClientFactory;
import org.example.basic.AddressValidation;
import org.example.basic.FreightCalculation;
import org.example.basic.TaxCalculation;

public class UsaClientFactory extends AbstractClientFactory {

    public TaxCalculation makeTaxCalculation() {
        return new UsaTaxCalculation();
    }

    public FreightCalculation makeFreightCalculation() {
        return new UsaFreightCalculation();
    }

    public AddressValidation makeAddressVerification() {
        return new UsaAddressValidation();
    }
}
