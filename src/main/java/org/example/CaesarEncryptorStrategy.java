package org.example;

public class CaesarEncryptorStrategy implements EncryptorStrategy {

    private static final int SHIFT = 3;

    @Override
    public String encrypt(String string){
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isLetter(c)) {
                char shifted = (char) (c + SHIFT);
                if ((Character.isUpperCase(c) && shifted > 'Z') || (Character.isLowerCase(c) && shifted > 'z')) {
                    shifted = (char) (c - (26 - SHIFT));
                }
                encrypted.append(shifted);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    @Override
    public String decrypt(String string) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isLetter(c)) {
                char shifted = (char) (c - SHIFT);
                if ((Character.isUpperCase(c) && shifted < 'A') || (Character.isLowerCase(c) && shifted < 'a')) {
                    shifted = (char) (c + (26 - SHIFT));
                }
                decrypted.append(shifted);
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}
