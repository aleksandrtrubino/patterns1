import org.example.CaesarEncryptorStrategy;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CaesarEncryptorStrategyTests {

    private final CaesarEncryptorStrategy caesarEncryptorStrategy = new CaesarEncryptorStrategy();
    final String STRING_TO_ENCRYPT = "String to encrypt";
    final String ENCRYPTED_STRING = "Vwulqj wr hqfubsw";
    final String NAME_PRINTED = "Name: Caesar cipher\n";
    final String DESCRIPTION_PRINTED = """
                Description:
                The Caesar cipher is one of the simplest and most well-known encryption techniques. 
                It is a substitution cipher where each letter in the plaintext is shifted a certain 
                number of places down or up the alphabet.
                """;
    final String EXECUTION_TIME_PRINTED = "Execution time: ";


    @Test
    public void givenStringToEncrypt_whenEncrypt_thenStringEncrypted(){
        String encryptedString = caesarEncryptorStrategy.encrypt(STRING_TO_ENCRYPT);
        assertEquals(ENCRYPTED_STRING, encryptedString);
    }

    @Test
    public void givenNullStringToEncrypt_whenEncrypt_thenExceptionThrown(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            String encryptedString = caesarEncryptorStrategy.encrypt(null);
        });
    }

    @Test
    public void givenEncryptedString_whenDecrypt_thenStringDecrypted(){
        String decryptedString = caesarEncryptorStrategy.decrypt(ENCRYPTED_STRING);
        assertEquals(STRING_TO_ENCRYPT, decryptedString);
    }

    @Test
    public void givenNullEncryptedString_whenDecrypt_thenStringDecrypted(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            String decryptedString = caesarEncryptorStrategy.decrypt(null);
        });
    }

    @Test
    public void whenPrintName_thenNamePrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        caesarEncryptorStrategy.printName();
        assertEquals(NAME_PRINTED, outputStream.toString());
    }

    @Test
    public void whenPrintDescription_thenDescriptionPrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        caesarEncryptorStrategy.printDescription();
        assertEquals(DESCRIPTION_PRINTED, outputStream.toString());
    }

    @Test
    public void whenCalculateAndPrintExecutionTime_ExecutionTimeCalculatedAndPrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        caesarEncryptorStrategy.calculateAndPrintExecutionTime();
        assertTrue(outputStream.toString().contains(EXECUTION_TIME_PRINTED));
    }

    @Test
    public void whenTemplateMethod_thenPrinted(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        caesarEncryptorStrategy.templateMethod();
        assertTrue(outputStream.toString().contains(NAME_PRINTED+DESCRIPTION_PRINTED+EXECUTION_TIME_PRINTED));
    }

}
