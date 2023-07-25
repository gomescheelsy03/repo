package project4;

public class MyString {

    // Instance variable to store the string
    private java.lang.String str;

    // Constructor that initializes the instance variable with the provided string
    public MyString(java.lang.String str) {
        this.str = str;
    }

    // Method that returns the length of the string
    public int length() {
        return str.length();
    }

    // Method that returns the character at the specified index in the string
    public char charAt(int index) {
        return str.charAt(index);
    }

    // Method that returns a substring of the string 
    // The substring begins at the specified beginIndex and extends to the character at index endIndex - 1
    public java.lang.String substring(int beginIndex, int endIndex) {
        return str.substring(beginIndex, endIndex);
    }

    // Method that returns the index within this string of the first occurrence of the specified character
    public int indexOf(int ch) {
        return str.indexOf(ch);
    }

}

