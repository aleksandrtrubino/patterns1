package org.example;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class AesEncryptorStrategy extends EncryptorStrategy {
    private final SecretKey secretKey;

    public AesEncryptorStrategy() {
        byte[] byteArray = {10, 20, 30, 40, 50,10, 20, 30, 40, 50,10, 20, 30, 40, 50,10};
        secretKey = new SecretKeySpec(byteArray, "AES");
    }

    @Override
    public String encrypt(String string) {
        try{
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(string.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }catch (Exception e){
            throw new CryptoException();
        }

    }

    @Override
    public String decrypt(String string) {
        try{
            Cipher cipher = Cipher.getInstance("AES");
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
        System.out.print("Name: AES\n");
    }

    @Override
    public void printDescription() {
        String description = """
                Description:
                The AES (Advanced Encryption Standard) algorithm is a symmetric block cipher that operates 
                on fixed-size blocks of data. It was adopted by the U.S. government in 2001 as the standard 
                encryption algorithm for securing sensitive information. AES supports key sizes of 128, 192,
                or 256 bits and operates on 128-bit blocks of data.
                """;
        System.out.print(description);
    }

}
