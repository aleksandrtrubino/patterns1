package org.example.russia;

import org.example.basic.AddressVerification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RussiaAddressVerification implements AddressVerification {

    final static private String regex = "^[\\p{IsCyrillic}/\\\\.,\\-]+$";
    final static private Pattern pattern = Pattern.compile(regex);

    @Override
    public boolean verify(String address) {
        Matcher matcher = pattern.matcher(address);
        return matcher.find();
    }
}
