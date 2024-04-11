/*
 * Class: CMSC204 
 * Instructor: Gary Thai
 * Due: 04/21/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Chelsy Gomes_____
*/


package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utility class for converting Morse code into English.
 * It relies on MorseCodeTree for the conversion process.
 */
public class MorseCodeConverter {
    private static MorseCodeTree morseCodeTree = new MorseCodeTree();

    /**
     * Converts a string of Morse code into English. 
     * Each Morse code letter is separated by a space and words are separated by a slash ('/').
     * 
     * @param code The Morse code string to be converted.
     * @return The English translation of the Morse code string.
     */
    public static String convertToEnglish(String morseCode) {
        StringBuilder english = new StringBuilder();
        for (String word : morseCode.trim().split(" / ")) {
            for (String letterCode : word.split(" ")) {
                String englishLetter = morseCodeTree.fetch(letterCode);
                if (englishLetter != null) { // Ensure non-null result
                    english.append(englishLetter);
                }
            }
            english.append(" "); // Space between words
        }
        return english.toString().trim(); // Remove trailing space
    }




    /**
     * Converts a file containing Morse code into English.
     * 
     * @param codeFile The file containing Morse code.
     * @return The English translation of the Morse code.
     * @throws FileNotFoundException If the file cannot be found.
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        // This check helps ensure that you are looking for the file in the correct location
        if (!codeFile.exists()) {
            System.err.println("File not found: " + codeFile.getAbsolutePath());
            throw new FileNotFoundException("File not found: " + codeFile.getAbsolutePath());
        }

        Scanner scanner = new Scanner(codeFile);
        StringBuilder morseCode = new StringBuilder();

        while (scanner.hasNextLine()) {
            morseCode.append(scanner.nextLine().trim()).append(" / ");
        }
        scanner.close();

        return convertToEnglish(morseCode.toString().trim());
    }


    /**
     * Returns a string with all the data in the MorseCodeTree in LNR (in-order) order,
     * with a space between each data.
     * 
     * @return A string representing the contents of the MorseCodeTree in LNR order.
     */
    public static String printTree() {
        ArrayList<String> treeContents = morseCodeTree.toArrayList();
        System.out.println(treeContents); // Debugging line to inspect the list
        return String.join(" ", treeContents);
    }

}