/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Due: 10/09/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Chelsy Gomes_____
*/

package application;

/**
 * This class provides methods for managing encryption and decryption using Caesar and Bellaso ciphers.
 * It offers functionality to determine if a string is within the allowable bounds of ASCII codes,
 * encrypt/decrypt using Caesar Cipher, and encrypt/decrypt using Bellaso Cipher.
 * 
 * @author Chelsy Gomes
 * @version 10/09/2023
 * 
 */

public class CryptoManager {

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	public static boolean isStringInBounds(String plainText) {
		for (char c : plainText.toCharArray()) {
			if (c < LOWER_RANGE || c > UPPER_RANGE) {
				return false;
			}
		}
		return true;
	}

	public static String caesarEncryption(String plainText, int key) {
		if (!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}
		StringBuilder result = new StringBuilder();
		for (char c : plainText.toCharArray()) {
			result.append((char) wrapCharacter(c + key));
		}
		return result.toString();
	}

	public static String caesarDecryption(String encryptedText, int key) {
		StringBuilder result = new StringBuilder();
		for (char c : encryptedText.toCharArray()) {
			result.append((char) wrapCharacter(c - key));
		}
		return result.toString();
	}

	public static String bellasoEncryption(String plainText, String bellasoStr) {
		StringBuilder result = new StringBuilder();
		int bellasoLen = bellasoStr.length();
		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);
			char k = bellasoStr.charAt(i % bellasoLen);
			result.append((char) wrapCharacter(c + k));
		}
		return result.toString();
	}

	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		StringBuilder result = new StringBuilder();
		int bellasoLen = bellasoStr.length();
		for (int i = 0; i < encryptedText.length(); i++) {
			char c = encryptedText.charAt(i);
			char k = bellasoStr.charAt(i % bellasoLen);
			result.append((char) wrapCharacter(c - k));
		}
		return result.toString();
	}

	private static int wrapCharacter(int c) {
		while (c > UPPER_RANGE) {
			c -= RANGE;
		}
		while (c < LOWER_RANGE) {
			c += RANGE;
		}
		return c;
	}
}
