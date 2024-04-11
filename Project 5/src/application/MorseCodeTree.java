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

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    private TreeNode<String> root;

    public MorseCodeTree() {
        root = new TreeNode<>("");
        buildTree();
    }

    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    @Override
    public void insert(String code, String result) {
        addNode(root, code, result);
    }

    @Override
    public void addNode(TreeNode<String> localRoot, String code, String letter) {
        if (code.length() == 1) {
            if (code.charAt(0) == '.') {
                if (localRoot.getLeft() == null) {
                    localRoot.setLeft(new TreeNode<>(letter));
                } else {
                    localRoot.getLeft().setData(letter);
                }
            } else if (code.charAt(0) == '-') {
                if (localRoot.getRight() == null) {
                    localRoot.setRight(new TreeNode<>(letter));
                } else {
                    localRoot.getRight().setData(letter);
                }
            }
        } else {
            if (code.charAt(0) == '.') {
                if (localRoot.getLeft() == null) {
                    localRoot.setLeft(new TreeNode<>(""));
                }
                addNode(localRoot.getLeft(), code.substring(1), letter);
            } else if (code.charAt(0) == '-') {
                if (localRoot.getRight() == null) {
                    localRoot.setRight(new TreeNode<>(""));
                }
                addNode(localRoot.getRight(), code.substring(1), letter);
            }
        }
    }

    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    @Override
    public String fetchNode(TreeNode<String> localRoot, String code) {
        if (localRoot == null) return ""; // Protect against null dereference

        if (code.isEmpty()) {
            return localRoot.getData();
        } else {
            if (code.charAt(0) == '.') {
                return fetchNode(localRoot.getLeft(), code.substring(1));
            } else if (code.charAt(0) == '-') {
                return fetchNode(localRoot.getRight(), code.substring(1));
            }
        }
        return ""; // In case of an invalid path
    }

    @Override
    public MorseCodeTree delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Delete operation is not supported.");
    }

    @Override
    public MorseCodeTree update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Update operation is not supported.");
    }

    @Override
    public void buildTree() {
        // Alphabet
        insert(".", "e");
        insert("-", "t");
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert("--.-", "q");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        
    }

    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }

    public void LNRoutputTraversal(TreeNode<String> localRoot, ArrayList<String> list) {
        if (localRoot != null) {
            LNRoutputTraversal(localRoot.getLeft(), list);
            if (!localRoot.getData().equals("")) {
                list.add(localRoot.getData());
            }
            LNRoutputTraversal(localRoot.getRight(), list);
        }
    }
}