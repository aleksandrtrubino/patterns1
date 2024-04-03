import org.example.CryptoException;
import org.example.DesEncryptorStrategy;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class DesEncryptorStrategyTests {

    private final DesEncryptorStrategy desEncryptorStrategy = new DesEncryptorStrategy();
    final String STRING_TO_ENCRYPT = "String to encrypt";
    final String ENCRYPTED_STRING = "yWHo2j32D+Hqo48Fuve3A0VBln+k1l9i";
    final String NAME_PRINTED = "Name: DES\n";
    final String DESCRIPTION_PRINTED = """
                Description:
                DES (Data Encryption Standard) encryption is a symmetric-key block cipher algorithm. It was 
                developed in the early 1970s by IBM and was adopted by the U.S. government as a standard for 
                encrypting sensitive data. DES operates on 64-bit blocks of plaintext and uses a 56-bit key 
                for encryption.
                """;
    final String EXECUTION_TIME_PRINTED = "Execution time: ";


    @Test
    public void givenStringToEncrypt_whenEncrypt_thenStringEncrypted(){
        String encryptedString = desEncryptorStrategy.encrypt(STRING_TO_ENCRYPT);
        assertEquals(ENCRYPTED_STRING, encryptedString);
    }

    @Test
    public void givenNullStringToEncrypt_whenEncrypt_thenExceptionThrown(){
        Exception exception = assertThrows(CryptoException.class, () -> {
            String encryptedString = desEncryptorStrategy.encrypt(null);
        });
    }

    @Test
    public void givenEncryptedString_whenDecrypt_thenStringDecrypted(){
        String decryptedString = desEncryptorStrategy.decrypt(ENCRYPTED_STRING);
        assertEquals(STRING_TO_ENCRYPT, decryptedString);
    }

    @Test
    public void givenNullEncryptedString_whenDecrypt_thenStringDecrypted(){
        Exception exception = assertThrows(CryptoException.class, () -> {
            String decryptedString = desEncryptorStrategy.decrypt(null);
        });
    }

    @Test
    public void whenPrintName_thenNamePrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        desEncryptorStrategy.printName();
        assertEquals(NAME_PRINTED, outputStream.toString());
    }

    @Test
    public void whenPrintDescription_thenDescriptionPrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        desEncryptorStrategy.printDescription();
        assertEquals(DESCRIPTION_PRINTED, outputStream.toString());
    }

    @Test
    public void whenCalculateAndPrintExecutionTime_ExecutionTimeCalculatedAndPrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        desEncryptorStrategy.calculateAndPrintExecutionTime();
        assertTrue(outputStream.toString().contains(EXECUTION_TIME_PRINTED));
    }

    @Test
    public void whenTemplateMethod_thenPrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        desEncryptorStrategy.templateMethod();
        assertTrue(outputStream.toString().contains(NAME_PRINTED+DESCRIPTION_PRINTED+EXECUTION_TIME_PRINTED));
    }
}
