/*
 * Class: CMSC204
 * Instructor:Gary Thai
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;



public class SolitaireMatchingGame {
    public static void main(String[] args) {
        // Generate 12 random values and add them to an ArrayList
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            numbers.add(random.nextInt(90) + 10); // Generates numbers between 10 and 99
        }
        System.out.println("Initial list of numbers:");
        System.out.println(numbers);

        // Play the game
        boolean wasRemoved;
        do {
            wasRemoved = playRound(numbers);
        } while (wasRemoved); // Continue playing rounds until no more pairs can be removed

        // Check if the player has won
        if (numbers.isEmpty()) {
            System.out.println("Congratulations! You have won the game.");
        } else {
            System.out.println("Game Over. Remaining numbers:");
            System.out.println(numbers);
        }
    }

    private static boolean playRound(List<Integer> numbers) {
        if (numbers.size() < 2) return false; // Not enough numbers to play

        boolean wasRemoved = false;
        ListIterator<Integer> iterator = numbers.listIterator();
        Integer current = iterator.next(); // Start with the first number

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (isMatch(current, next)) {
                // Remove the matching pair
                iterator.remove(); // Removes 'next'
                iterator.previous(); // Move back to the element before 'current'
                iterator.remove(); // Removes 'current'
                
                // If possible, set 'current' to the previous element, else to the next
                if (iterator.hasPrevious()) {
                    current = iterator.previous();
                    iterator.next(); // Adjust the iterator's cursor position
                } else if (iterator.hasNext()) {
                    current = iterator.next();
                }
                
                wasRemoved = true;
                // Break the loop if we've removed elements, to restart the process
                break;
            } else {
                // Move to the next pair
                current = next;
            }
        }
        return wasRemoved;
    }

    private static boolean isMatch(Integer first, Integer second) {
        int firstLeftDigit = first / 10;
        int firstRightDigit = first % 10;
        int secondLeftDigit = second / 10;
        int secondRightDigit = second % 10;
        
        return firstLeftDigit == secondLeftDigit || firstRightDigit == secondRightDigit;
    }
}
