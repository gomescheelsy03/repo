package application;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * This is a JUnit test class for the MorseCodeTree class.
 * It thoroughly tests all functionalities including building the tree, inserting nodes,
 * fetching letters, and converting the tree to an ArrayList.
 * 
 * Written by: Chelsy Gomes
 * Class: CMSC204
 * Instructor: Gary Thai
 * Date: 04/21/2024
 */
public class MorseCodeTreeStudentTest {

    MorseCodeTree tree;

    @Before
    public void setUp() {
        // Initialize MorseCodeTree before each test
        tree = new MorseCodeTree();
    }

    @Test
    public void testBuildTree() {
        // Fetch a few known Morse code characters to validate the tree construction
        assertEquals("Initial tree construction failed for character 'e'", "e", tree.fetch("."));
        assertEquals("Initial tree construction failed for character 't'", "t", tree.fetch("-"));
        assertEquals("Initial tree construction failed for character 'i'", "i", tree.fetch(".."));
    }

    @Test
    public void testInsertAndFetch() {
        // Test inserting a new code and fetching the letter
        tree.insert("----", "x");
        assertEquals("Insert or fetch failed for new Morse code '----' with letter 'x'", "x", tree.fetch("----"));
    }

    @Test
    public void testFetchWithInvalidCode() {
        // Fetching with a non-existing code should return an empty string
        assertEquals("Fetch with invalid Morse code should return an empty string", "", tree.fetch("......."));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDeleteUnsupported() {
        // Attempting to delete should throw UnsupportedOperationException
        tree.delete("e");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUpdateUnsupported() {
        // Attempting to update should throw UnsupportedOperationException
        tree.update();
    }

    @Test
    public void testToArrayList() {
        // Fetching the ArrayList representation of the Morse code tree
        ArrayList<String> list = tree.toArrayList();
        // Corrected expected list without the space character
        ArrayList<String> expected = new ArrayList<>();
        expected.add("h");
        expected.add("s");
        expected.add("v");
        expected.add("i");
        expected.add("f");
        expected.add("u");
        expected.add("e");
        expected.add("l");
        expected.add("r");
        expected.add("a");
        expected.add("p");
        expected.add("w");
        expected.add("j");
        expected.add("b");
        expected.add("d");
        expected.add("x");
        expected.add("n");
        expected.add("c");
        expected.add("k");
        expected.add("y");
        expected.add("t");
        expected.add("z");
        expected.add("g");
        expected.add("q");
        expected.add("m");
        expected.add("o");
        // Verify the toArrayList method works correctly
        assertEquals("ArrayList representation of Morse code tree is incorrect", expected, list);
    }


    @Test
    public void testGetRoot() {
        // Verify root node is correctly initialized
        assertNotNull("getRoot should not return null after tree construction", tree.getRoot());
        assertEquals("getRoot should return a TreeNode with empty string data after tree construction", "", tree.getRoot().getData());
    }

    @Test
    public void testSetRoot() {
        // Set a new root and verify
        TreeNode<String> newRoot = new TreeNode<>("newRoot");
        tree.setRoot(newRoot);
        assertEquals("setRoot failed to update the root of the tree", "newRoot", tree.getRoot().getData());
    }
}

