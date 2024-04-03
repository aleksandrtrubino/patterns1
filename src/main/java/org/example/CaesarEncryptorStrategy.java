package org.example;

public class CaesarEncryptorStrategy extends EncryptorStrategy {

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

    @Override
    public void printName() {
        System.out.print("Name: Caesar cipher\n");
    }

    @Override
    public void printDescription() {
        String description = """
                Description:
                The Caesar cipher is one of the simplest and most well-known encryption techniques. 
                It is a substitution cipher where each letter in the plaintext is shifted a certain 
                number of places down or up the alphabet.
                """;
        System.out.print(description);
    }


}
