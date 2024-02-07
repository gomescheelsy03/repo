package application;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {

    // Constructor is not necessary since all methods are static
    private PasswordCheckerUtility() {
        throw new IllegalStateException("Utility class");
    }

    // Compares two passwords for equality and throws an exception if they do not match
    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (!password.equals(passwordConfirm)) {
            throw new UnmatchedException();
        }
    }

    // Compares two passwords for equality and returns a boolean result
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }

    // Checks if the password has a valid length and throws an exception if it does not
    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() < 6) {
            throw new LengthException();
        }
        return true;
    }

    // Checks for the presence of an uppercase character in the password
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        if (!password.matches(".*[A-Z].*")) {
            throw new NoUpperAlphaException();
        }
        return true;
    }

    // Checks for the presence of a lowercase character in the password
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        if (!password.matches(".*[a-z].*")) {
            throw new NoLowerAlphaException();
        }
        return true;
    }

    // Checks for the presence of a digit in the password
    public static boolean hasDigit(String password) throws NoDigitException {
        if (!password.matches(".*\\d.*")) {
            throw new NoDigitException();
        }
        return true;
    }

    // Checks for the presence of a special character in the password
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            throw new NoSpecialCharacterException();
        }
        return true;
    }

    // Checks for sequences of the same character and throws an exception if found
    public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
                throw new InvalidSequenceException();
            }
        }
        return true;
    }

    // Validates the password against all criteria
    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        return isValidLength(password) &&
               hasUpperAlpha(password) &&
               hasLowerAlpha(password) &&
               hasDigit(password) &&
               hasSpecialChar(password) &&
               NoSameCharInSequence(password);
    }

    // Checks if the password length is between 6 and 9 characters
    public static boolean hasBetweenSixAndNineChars(String password) {
        return password.length() >= 6 && password.length() <= 9;
    }

    // Checks if the password is weak (meets minimum criteria but is not strong)
    public static boolean isWeakPassword(String password) throws WeakPasswordException {
        if (hasBetweenSixAndNineChars(password)) {
            throw new WeakPasswordException();
        }
        return true;
    }

    // Gets a list of invalid passwords with their issues
 // Inside PasswordCheckerUtility class

    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPasswords = new ArrayList<>();
        for (String password : passwords) {
            try {
                isValidPassword(password);
            } catch (Exception e) {
                
            	invalidPasswords.add(password + " " + e.getMessage());
            }
        }
        return invalidPasswords;
    }


}