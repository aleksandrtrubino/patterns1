package org.example;

public class Main {
    public static void main(String[] args) {

        Encryptor encryptor = new Encryptor(new AesEncryptorStrategy());
        String string = "String to encrypt";
        String encryptedString = encryptor.encrypt(string);
        String decryptedString = encryptor.decrypt(encryptedString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);

        System.out.println("__________________");

        encryptor.setEncryptorStrategy(new CaesarEncryptorStrategy());
        encryptedString = encryptor.encrypt(string);
        decryptedString = encryptor.decrypt(encryptedString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);

        System.out.println("__________________");

        encryptor.setEncryptorStrategy(new DesEncryptorStrategy());
        encryptedString = encryptor.encrypt(string);
        decryptedString = encryptor.decrypt(encryptedString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);

//        Encryptor encryptor = new Encryptor(new AesEncryptorStrategy());
//        encryptor.templateMethod();

//        System.out.println("__________________");
//
//        encryptor.setEncryptorStrategy(new CaesarEncryptorStrategy());
//        encryptor.templateMethod();
//
//        System.out.println("__________________");
//
//        encryptor.setEncryptorStrategy(new DesEncryptorStrategy());
//        encryptor.templateMethod();


    }
}