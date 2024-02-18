/*
 * Class: CMSC204
 * Instructor: Gary Thai 
 * Description: Signals that an attempt was made to remove an element from an empty queue, which is not possible. 
 * Due: 02/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Chelsy Gomes_________
*/

package application;

class QueueUnderflowException extends Exception {

    public QueueUnderflowException(String underflow_Exception) {
        super(underflow_Exception);
    }

}
