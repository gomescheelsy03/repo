package project4;

import static org.junit.Assert.*;
import org.junit.Test;

// This is the JUnit test class for MyString
public class StringTest {

    @Test
    // Test case for testing the length method of the MyString class
    public void testLength() {
        // Create a new MyString object with the string "Hello, world!"
        MyString myStr = new MyString("Hello, world!");
        // Assert that the length of the string is 13
        assertEquals(13, myStr.length());
    }
    
    @Test
    // Test case for testing the charAt method of the MyString class
    public void testCharAt() {
        // Create a new MyString object with the string "Hello, world!"
        MyString myStr = new MyString("Hello, world!");
        // Assert that the character at the 0th, 7th and 12th index are 'H', 'w', and '!', respectively
        assertEquals('H', myStr.charAt(0));
        assertEquals('w', myStr.charAt(7));
        assertEquals('!', myStr.charAt(12));
    }
    
    @Test
    // Test case for testing the substring method of the MyString class
    public void testSubstring() {
        // Create a new MyString object with the string "Hello, world!"
        MyString myStr = new MyString("Hello, world!");
        // Assert that the substring from index 0 to 5 is "Hello"
        assertEquals("Hello", myStr.substring(0, 5));
        // Assert that the substring from index 5 to 13 is ", world!"
        assertEquals(", world!", myStr.substring(5, 13)); // corrected
        // Assert that the substring from index 7 to 13 is "world!"
        assertEquals("world!", myStr.substring(7, 13)); 
    }
    
    @Test
    // Test case for testing the indexOf method of the MyString class
    public void testIndexOf() {
        // Create a new MyString object with the string "Hello, world!"
        MyString myStr = new MyString("Hello, world!");
        // Assert that the index of character 'w' in the string is 7
        assertEquals(7, myStr.indexOf('w'));
        // Assert that the index of character 'H' in the string is 0
        assertEquals(0, myStr.indexOf('H'));
        // Assert that the index of character 'z' in the string is -1 as 'z' does not exist in the string
        assertEquals(-1, myStr.indexOf('z'));
    }
}

