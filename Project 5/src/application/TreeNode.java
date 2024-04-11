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

/**
 * A generic TreeNode class used in the MorseCodeTree.
 * It includes data of type T and references to the left and right children.
 * 
 * @param <T> The type of data stored in the node.
 */
public class TreeNode<T> {
    // Data stored in this node
    private T data;
    // Left child of the node
    private TreeNode<T> left;
    // Right child of the node
    private TreeNode<T> right;

    /**
     * Constructor to create a new TreeNode with no children.
     * 
     * @param dataNode The data to be stored in the TreeNode.
     */
    public TreeNode(T dataNode) {
        this.data = dataNode;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructor used for making deep copies.
     * 
     * @param node The node to make a copy of.
     */
    public TreeNode(TreeNode<T> node) {
        this.data = node.data; // Assuming data is immutable or that this is okay per use case
        this.left = node.left; // Note: This does not create a deep copy of children
        this.right = node.right;
    }

    /**
     * Gets the data within this TreeNode.
     * 
     * @return The data within the TreeNode.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data of this TreeNode.
     * 
     * @param data The data to set in this TreeNode.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets the left child of this TreeNode.
     * 
     * @return The left child.
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Sets the left child of this TreeNode.
     * 
     * @param left The TreeNode to set as the left child.
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Gets the right child of this TreeNode.
     * 
     * @return The right child.
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Sets the right child of this TreeNode.
     * 
     * @param right The TreeNode to set as the right child.
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
