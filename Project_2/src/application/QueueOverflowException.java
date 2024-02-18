/*
 * Class: CMSC204
 * Instructor: Gary Thai 
 * Description: An exception class that indicates a queue data structure has reached its maximum capacity and no additional elements can be added. 
 * Due: 02/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Chelsy Gomes_________
*/

package application;

class QueueOverflowException extends Exception {

    public QueueOverflowException(String overflow_Exception) {
         super(overflow_Exception);
    }

}
