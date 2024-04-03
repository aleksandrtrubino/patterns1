package org.example;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DesEncryptorStrategy implements EncryptorStrategy {
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
}
