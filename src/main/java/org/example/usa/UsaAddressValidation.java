package org.example.us;

import org.example.basic.AddressValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsaAddressValidation implements AddressValidation {

    final static private String regex = "^[\\p{IsLatin}0-9/\\\\.,\\-\\s]+$";
    final static private Pattern pattern = Pattern.compile(regex);

    @Override
    public boolean validate(String address) {
        Matcher matcher = pattern.matcher(address);
        return matcher.find();
    }
}
