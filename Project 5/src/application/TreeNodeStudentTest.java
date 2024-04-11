package application;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit test class for the TreeNode class in the MorseCodeTree project.
 * It tests all functionalities of the TreeNode class including constructors, getters, and setters.
 * 
 * Written by: Chelsy Gomes
 * Class: CMSC204
 * Instructor: Gary Thai
 * Date: 04/21/2024
 */
public class TreeNodeStudentTest {

    // Declare TreeNode objects for testing
    private TreeNode<String> node;
    private TreeNode<String> leftChild;
    private TreeNode<String> rightChild;

    /**
     * Setup method to initialize objects before each test.
     */
    @Before
    public void setUp() {
        // Initialize the TreeNode with sample data
        node = new TreeNode<>("root");
        // Initialize children for testing
        leftChild = new TreeNode<>("left");
        rightChild = new TreeNode<>("right");
    }

    /**
     * Test the parameterized constructor of TreeNode.
     */
    @Test
    public void testTreeNodeConstructorWithData() {
        assertEquals("The data should be 'root'.", "root", node.getData());
    }

    /**
     * Test the copy constructor of TreeNode.
     */
    @Test
    public void testTreeNodeCopyConstructor() {
        TreeNode<String> copyNode = new TreeNode<>(node);
        assertEquals("The data of the copied node should match the original.", node.getData(), copyNode.getData());
        // Note: This does not test deep copying of children since the constructor does not perform deep copy
    }

    /**
     * Test the getData method.
     */
    @Test
    public void testGetData() {
        assertEquals("The data should be 'root'.", "root", node.getData());
    }

    /**
     * Test the setData method.
     */
    @Test
    public void testSetData() {
        node.setData("newRoot");
        assertEquals("The data should now be 'newRoot'.", "newRoot", node.getData());
    }

    /**
     * Test the getLeft method.
     */
    @Test
    public void testGetLeft() {
        node.setLeft(leftChild);
        assertEquals("The left child should be 'left'.", leftChild, node.getLeft());
    }

    /**
     * Test the setLeft method.
     */
    @Test
    public void testSetLeft() {
        node.setLeft(leftChild);
        assertNotNull("The left child should not be null.", node.getLeft());
        assertEquals("The left child's data should be 'left'.", "left", node.getLeft().getData());
    }

    /**
     * Test the getRight method.
     */
    @Test
    public void testGetRight() {
        node.setRight(rightChild);
        assertEquals("The right child should be 'right'.", rightChild, node.getRight());
    }

    /**
     * Test the setRight method.
     */
    @Test
    public void testSetRight() {
        node.setRight(rightChild);
        assertNotNull("The right child should not be null.", node.getRight());
        assertEquals("The right child's data should be 'right'.", "right", node.getRight().getData());
    }
}
