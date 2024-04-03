package org.example;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DesEncryptorStrategy extends EncryptorStrategy {
    private final SecretKey secretKey;

    public DesEncryptorStrategy() {
        byte[] byteArray = {10, 20, 30, 40, 50, 10, 20, 30};
        secretKey = new SecretKeySpec(byteArray, "DES");
    }

    @Override
    public String encrypt(String string){
        try{
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(string.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }catch (Exception e){
            throw new CryptoException();
        }

    }

    @Override
    public String decrypt(String string){
        try{
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] encryptedBytes = Base64.getDecoder().decode(string);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes);
        }catch (Exception e){
            throw new CryptoException();
        }

    }

    @Override
    public void printName() {
        System.out.print("Name: DES\n");
    }

    @Override
    public void printDescription() {
        String description = """
                Description:
                DES (Data Encryption Standard) encryption is a symmetric-key block cipher algorithm. It was 
                developed in the early 1970s by IBM and was adopted by the U.S. government as a standard for 
                encrypting sensitive data. DES operates on 64-bit blocks of plaintext and uses a 56-bit key 
                for encryption.
                """;
        System.out.print(description);
    }


}
