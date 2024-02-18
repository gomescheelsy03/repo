/*
 * Class: CMSC204
 * Instructor: Gary Thai
 * Description: Used to indicate an error condition when an attempt is made to remove an element from an empty stack, which is an invalid operation. 
 * Due: 02/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Chelsy Gomes_________
*/

package application;

class StackUnderflowException extends Exception {

    public StackUnderflowException(String underflow_Exception) {
        super(underflow_Exception);
    }

}
