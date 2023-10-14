package application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents student test cases for the CryptoManager object.
 * It is intended to cover every public method of the CryptoManager class
 * for thorough testing, ensuring proper functionality and reliability.
 * 
 * @author Chelsy Gomes
 * @version 10/09/2023
 * 
 */

public class CryptoManagerTestStudent {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("VALID STRING"));
        assertFalse(CryptoManager.isStringInBounds("INVALID{STRING"));
    }

    @Test
    public void testEncryptCaesar() {
        assertEquals("IFMMP!XPSME", CryptoManager.caesarEncryption("HELLO WORLD", 1));
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("INVALID{STRING", 1));
    }

    @Test
    public void testDecryptCaesar() {
        assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("IFMMP!XPSME", 1));
    }

    @Test
    public void testEncryptBellaso() {
        String bellasoStr = "KEYSTRING";
        String plainText = "HELLO_WORLD";
        String encryptedText = CryptoManager.bellasoEncryption(plainText, bellasoStr);
        assertNotEquals(plainText, encryptedText);  // Ensure encryption happened
    }

    @Test
    public void testDecryptBellaso() {
        String bellasoStr = "KEYSTRING";
        String originalText = "HELLO_WORLD";
        String encryptedText = CryptoManager.bellasoEncryption(originalText, bellasoStr);
        assertEquals(originalText, CryptoManager.bellasoDecryption(encryptedText, bellasoStr));
    }
}
