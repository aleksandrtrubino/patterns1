package org.example;

public abstract class EncryptorStrategy {

    public abstract String encrypt(String string);
    public abstract String decrypt(String string);

    public void templateMethod(){
        printName();
        printDescription();
        calculateAndPrintExecutionTime();
    }

    public abstract void printName();
    public abstract void printDescription();
    public  void calculateAndPrintExecutionTime(){
        String string = "Hello";
        Long startTime = System.nanoTime();
        decrypt(encrypt(string));
        Long endTime = System.nanoTime();
        System.out.print("Execution time: " + (endTime - startTime) + '\n');
    }


}
