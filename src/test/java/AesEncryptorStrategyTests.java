import org.example.AesEncryptorStrategy;
import org.example.CryptoException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class AesEncryptorStrategyTests {

    private final AesEncryptorStrategy aesEncryptorStrategy = new AesEncryptorStrategy();
    final String STRING_TO_ENCRYPT = "String to encrypt";
    final String ENCRYPTED_STRING = "bQZ5y9Rm3RmEh/cRAqPipNJ0YW4+vSmECzKEzaWXno8=";
    final String NAME_PRINTED = "Name: AES\n";
    final String DESCRIPTION_PRINTED = """
                Description:
                The AES (Advanced Encryption Standard) algorithm is a symmetric block cipher that operates 
                on fixed-size blocks of data. It was adopted by the U.S. government in 2001 as the standard 
                encryption algorithm for securing sensitive information. AES supports key sizes of 128, 192,
                or 256 bits and operates on 128-bit blocks of data.
                """;
    final String EXECUTION_TIME_PRINTED = "Execution time: ";


    @Test
    public void givenStringToEncrypt_whenEncrypt_thenStringEncrypted(){
        String encryptedString = aesEncryptorStrategy.encrypt(STRING_TO_ENCRYPT);
        assertEquals(ENCRYPTED_STRING, encryptedString);
    }

    @Test
    public void givenNullStringToEncrypt_whenEncrypt_thenExceptionThrown(){
        Exception exception = assertThrows(CryptoException.class, () -> {
            String encryptedString = aesEncryptorStrategy.encrypt(null);
        });
    }

    @Test
    public void givenEncryptedString_whenDecrypt_thenStringDecrypted(){
        String decryptedString = aesEncryptorStrategy.decrypt(ENCRYPTED_STRING);
        assertEquals(STRING_TO_ENCRYPT, decryptedString);
    }

    @Test
    public void givenNullEncryptedString_whenDecrypt_thenStringDecrypted(){
        Exception exception = assertThrows(CryptoException.class, () -> {
            String decryptedString = aesEncryptorStrategy.decrypt(null);
        });
    }

    @Test
    public void whenPrintName_thenNamePrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        aesEncryptorStrategy.printName();
        assertEquals(NAME_PRINTED, outputStream.toString());
    }

    @Test
    public void whenPrintDescription_thenDescriptionPrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        aesEncryptorStrategy.printDescription();
        assertEquals(DESCRIPTION_PRINTED, outputStream.toString());
    }

    @Test
    public void whenCalculateAndPrintExecutionTime_ExecutionTimeCalculatedAndPrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        aesEncryptorStrategy.calculateAndPrintExecutionTime();
        assertTrue(outputStream.toString().contains(EXECUTION_TIME_PRINTED));
    }

    @Test
    public void whenTemplateMethod_thenPrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        aesEncryptorStrategy.templateMethod();
        assertTrue(outputStream.toString().contains(NAME_PRINTED+DESCRIPTION_PRINTED+EXECUTION_TIME_PRINTED));
    }
}
