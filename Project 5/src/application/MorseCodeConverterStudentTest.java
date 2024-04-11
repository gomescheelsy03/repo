package application;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * JUnit test class for MorseCodeConverter.
 *
 * Tests all functionalities including conversion from strings and files to English,
 * and printing the Morse code tree.
 * Assumes MorseCodeTree is correctly implemented and functional.
 *
 * Author: Chelsy Gomes
 * Class: CMSC204
 * Instructor: Gary Thai
 * Due Date: 04/21/2024
 */
public class MorseCodeConverterStudentTest {

    private static File testFile;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Create a test Morse code file before all tests
        testFile = new File("morse_test.txt");
        PrintWriter writer = new PrintWriter(testFile);
        writer.println(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."); // "hello world"
        writer.close();
    }

    @Test
    public void testConvertToEnglishString() {
        String morseCode = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."; // "hello world"
        String expected = "hello world";
        assertEquals("Conversion from string failed.", expected, MorseCodeConverter.convertToEnglish(morseCode));
    }

    @Test
    public void testConvertToEnglishFile() throws FileNotFoundException {
        // Assumes setUpBeforeClass has successfully created the test file
        String expected = "hello world";
        assertEquals("Conversion from file failed.", expected, MorseCodeConverter.convertToEnglish(testFile));
    }

    @Test(expected = FileNotFoundException.class)
    public void testConvertToEnglishFileNotFound() throws FileNotFoundException {
        File nonExistentFile = new File("does_not_exist.txt");
        MorseCodeConverter.convertToEnglish(nonExistentFile); // This should throw FileNotFoundException
    }

    @Test
    public void testPrintTree() {
        // Assuming MorseCodeTree is correctly populated according to the Morse code standard.
        // This is a simplified check. A more thorough test might compare against a hard-coded expected value
        // that matches the MorseCodeTree content in LNR order.
        String treeContents = MorseCodeConverter.printTree();
        assertNotNull("Print tree should not return null.", treeContents);
        assertFalse("Print tree should not be empty.", treeContents.isEmpty());
        assertTrue("Print tree should contain space-separated letters.", treeContents.contains(" "));
    }

    @Test
    public void testEmptyStringConversion() {
        assertEquals("Converting an empty string should return an empty string.", "", MorseCodeConverter.convertToEnglish(""));
    }

    @Test
    public void testInvalidMorseCodeConversion() {
        // Assuming "--..--" is not a valid Morse code in the context of this implementation
        assertEquals("Converting an invalid Morse code should return an empty string.", "", MorseCodeConverter.convertToEnglish("--..--"));
        
       

    }
}

