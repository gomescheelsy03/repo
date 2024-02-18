/*
 * Class: CMSC204
 * Instructor: Gary Thai  
 * Description: Indicates that a stack data structure has been filled to its capacity, preventing the addition of any new elements. 
 * Due: 02/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Chelsy Gomes_________
*/
package application;

class StackOverflowException extends Exception {

    public StackOverflowException(String stack_is_full) {
        super(stack_is_full);
    }

}
