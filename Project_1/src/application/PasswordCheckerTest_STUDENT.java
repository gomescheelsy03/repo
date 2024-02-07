package application;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.ArrayList;

public class PasswordCheckerTest_STUDENT {
    ArrayList<String> passwords;

    @Before
    public void setUp() throws Exception {
        // Example list of passwords for testing various scenarios
        passwords = new ArrayList<>();
        passwords.add("123456"); // Too short
        passwords.add("ABCDEFGH"); // No lowercase or digits
        passwords.add("abcdefgh"); // No uppercase or digits
        passwords.add("ABCdef"); // No digits
        passwords.add("1234ABCD"); // No lowercase
        passwords.add("abcd1234"); // No uppercase
        passwords.add("Abcd1234"); // Valid but no special character
        passwords.add("Abc123!!"); // Valid
        passwords.add("aaaBBB111"); // Invalid sequence
        passwords.add("A1a!A1a!"); // Valid
    }

    @After
    public void tearDown() throws Exception {
        passwords = null;
    }

    @Test
    public void testIsValidPasswordTooShort() {
        try {
            PasswordCheckerUtility.isValidPassword("12345");
            fail("LengthException was expected but not thrown");
        } catch (LengthException e) {
            assertTrue("LengthException correctly thrown", true);
        } catch (Exception e) {
            fail("Wrong exception thrown for short password");
        }
    }

    @Test
    public void testIsValidPasswordNoUpperAlpha() {
        try {
            PasswordCheckerUtility.isValidPassword("abc123!!");
            fail("NoUpperAlphaException was expected but not thrown");
        } catch (NoUpperAlphaException e) {
            assertTrue("NoUpperAlphaException correctly thrown", true);
        } catch (Exception e) {
            fail("Wrong exception thrown for missing uppercase letter");
        }
    }

    @Test
    public void testIsValidPasswordNoLowerAlpha() {
        try {
            PasswordCheckerUtility.isValidPassword("ABC123!!");
            fail("NoLowerAlphaException was expected but not thrown");
        } catch (NoLowerAlphaException e) {
            assertTrue("NoLowerAlphaException correctly thrown", true);
        } catch (Exception e) {
            fail("Wrong exception thrown for missing lowercase letter");
        }
    }

    @Test
    public void testIsValidPasswordNoDigit() {
        try {
            PasswordCheckerUtility.isValidPassword("ABCdef!!");
            fail("NoDigitException was expected but not thrown");
        } catch (NoDigitException e) {
            assertTrue("NoDigitException correctly thrown", true);
        } catch (Exception e) {
            fail("Wrong exception thrown for missing digit");
        }
    }

    @Test
    public void testIsValidPasswordSuccessful() {
        try {
            assertTrue("Password is valid", PasswordCheckerUtility.isValidPassword("A1a!A1a!"));
        } catch (Exception e) {
            fail("No exception should be thrown for a valid password");
        }
    }


    @Test
    public void testIsValidPasswordInvalidSequence() {
        // Add a special character to the password to pass the special character check
        String password = "aaaBBB111!"; // Now contains a special character
        try {
            boolean result = PasswordCheckerUtility.isValidPassword(password);
            fail("Expected an InvalidSequenceException to be thrown, but the password was considered valid: " + result);
        } catch (InvalidSequenceException e) {
            // This is the expected behavior, so the test passes.
            assertTrue("The InvalidSequenceException was correctly thrown", true);
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getClass().getSimpleName() + ", with the message: " + e.getMessage());
        }
    }

    
    @Test
    public void testInvalidPasswords() {
        ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
        // Assuming the invalidPasswords method returns a list of strings describing why the password is invalid
        assertTrue("There should be invalid passwords detected", invalidPasswords.size() > 0);
    }
}
