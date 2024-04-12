package org.example.canada;

import org.example.basic.AbstractClientFactory;
import org.example.basic.AddressVerification;
import org.example.basic.FreightCalculation;
import org.example.basic.TaxCalculation;

public class RussiaClientFactory extends AbstractClientFactory {
    public TaxCalculation makeCalcTax(){
        return new CanadaCalcTax();
    }
    public FreightCalculation makeCalcFreight(){
        return new CanadaCalcFreight();
    }
    public AddressVerification makeAddressVer(){
        return new CanadaAddressVer();
}
