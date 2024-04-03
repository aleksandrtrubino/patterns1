package org.example;

public class Encryptor {

    private EncryptorStrategy encryptorStrategy;

    public Encryptor(EncryptorStrategy encryptorStrategy){
        this.encryptorStrategy = encryptorStrategy;
    }

    public void setEncryptorStrategy(EncryptorStrategy encryptorStrategy) {
        this.encryptorStrategy = encryptorStrategy;
    }

    public String encrypt(String string){
        return this.encryptorStrategy.encrypt(string);
    }

    public String decrypt(String string){
        return this.encryptorStrategy.decrypt(string);
    }
}
