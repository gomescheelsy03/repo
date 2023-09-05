/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg 
 * Description: This Java program initiates a game where the user attempts to guess a randomly selected color from a predetermined list across ten rounds, while also collecting and displaying user details such as name, description, and a due date.
 * Due: 09/05/2023
 * Platform/compiler:Eclipse 
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Chelsy Gomes 
*/


package assignment1;

import java.util.Scanner;
import java.util.Random;

public class ESPGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaring and initializing constants for the colors and number of rounds
        final String COLOR_RED = "Red";
        final String COLOR_GREEN = "Green";
        final String COLOR_BLUE = "Blue";
        final String COLOR_ORANGE = "Orange";
        final String COLOR_YELLOW = "Yellow";
        final int NUM_ROUNDS = 10;

        // Get user inputs
        System.out.print("Enter your name: "); // Prompt the user to enter their name
        String userName = scanner.nextLine(); // Read the user's name

        System.out.print("Describe yourself: "); // Prompt the user to describe themselves
        String describeYourself = scanner.nextLine(); // Read the user's description

        System.out.print("Due Date: "); // Prompt the user to enter the due date
        String dueDate = scanner.nextLine(); // Read the due date

        // Display assignment description
        System.out.println("CMSC203 Assignment1: Test your ESP skills!"); // Print assignment description

        // Initialize game variables
        Random random = new Random(); // Create a Random object to generate random numbers
        int score = 0; // Initialize the score to 0
        String selectedColor; // Declare a variable to hold the selected color

        // Loop through the number of rounds
        for (int i = 1; i <= NUM_ROUNDS; i++) {
            // Generate a random color using a random number
            int colorChoice = random.nextInt(5); // Generate a random number between 0 and 4
            switch (colorChoice) { // Determine the selected color based on the random number
                case 0:
                    selectedColor = COLOR_RED;
                    break;
                case 1:
                    selectedColor = COLOR_GREEN;
                    break;
                case 2:
                    selectedColor = COLOR_BLUE;
                    break;
                case 3:
                    selectedColor = COLOR_ORANGE;
                    break;
                default:
                    selectedColor = COLOR_YELLOW;
                    break;
            }

            // Display prompt for the current round
            System.out.println("Round " + i); // Print the current round number
            System.out.println("I am thinking of a color."); // Print the color hint
            System.out.println("Is it Red, Green, Blue, Orange, or Yellow?"); // Print the color options

            // Get the user's guess and validate it
            while (true) { // Loop indefinitely until a valid guess is entered
                System.out.print("Enter your guess: "); // Prompt the user to enter their guess
                String userGuess = scanner.nextLine(); // Read the user's guess

                // Validate user's guess
                if (userGuess.equalsIgnoreCase(COLOR_RED) || userGuess.equalsIgnoreCase(COLOR_GREEN) ||
                    userGuess.equalsIgnoreCase(COLOR_BLUE) || userGuess.equalsIgnoreCase(COLOR_ORANGE) ||
                    userGuess.equalsIgnoreCase(COLOR_YELLOW)) {

                    // Check if the guess matches the selected color
                    if (userGuess.equalsIgnoreCase(selectedColor)) { // If the guess matches the selected color
                        score++; // Increment the score by 1
                    }
                    System.out.println("I was thinking of " + selectedColor + "."); // Print the selected color
                    break;  // Exit the loop to move to the next round
                } else { // If the guess is invalid
                    System.out.println("You entered incorrect color. Is it Red, Green, Blue, Orange, or Yellow?"); // Print an error message
                }
            }
        }

        // Display final output
        System.out.println("Game Over"); // Print game over message
        System.out.println("You guessed " + score + " out of " + NUM_ROUNDS + " colors correctly."); // Print the score
        System.out.println("User Name: " + userName); // Print the user's name
        System.out.println("User Description: " + describeYourself); // Print the user's description
        System.out.println("Due Date: " + dueDate); // Print the due date

        scanner.close(); // Close the scanner
    }
}

