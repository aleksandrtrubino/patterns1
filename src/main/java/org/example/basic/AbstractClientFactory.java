package org.example;

import org.example.canada.CanadaClientFactory;
import org.example.us.USClientFactory;

public abstract class AbstractClientFactory {
    abstract TaxCalculation makeTaxCalculation();
    abstract FreightCalculation makeFreightCalculation();
    abstract AddressVerification makeAddressVerification();

    public static AbstractClientFactory createClientFactory(Country country){
        if(country == Country.US){
            return new USClientFactory();
        } else if(country == Country.CANADA){
            return new CanadaClientFactory();
        }
        throw new RuntimeException("Error in AbstractClientFactory constructor");
    }
}
