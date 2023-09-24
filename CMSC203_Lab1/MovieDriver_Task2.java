/**
 * The MovieDriver class serves as a driver program to collect and display 
 * information about movies using the Movie class.
 */

import java.util.Scanner;

public class MovieDriver_Task2 {

    /**
     * The main method of the MovieDriver class.
     * It prompts the user to enter details about movies and then displays the entered information.
     * @param args command-line arguments (unused in this context)
     */
    public static void main(String[] args) {

        // Create a Scanner object to capture user input.
        Scanner sc = new Scanner(System.in);
        
        // Instantiate a new Movie object.
        Movie movie = new Movie();

        // Variable to capture user choice on whether to continue entering movie details.
        String choice;

        do {
            // Prompt and read the title of the movie from the user.
            System.out.println("Enter the name of a movie");
            movie.setTitle(sc.nextLine());

            // Prompt and read the rating of the movie from the user.
            System.out.println("Enter the rating of the movie");
            movie.setRating(sc.nextLine());

            // Prompt and read the number of tickets sold for the movie from the user.
            System.out.println("Enter the number of tickets sold for this movie");
            movie.setSoldTickets(sc.nextInt());

            // Clear the scanner's newline.
            sc.nextLine();

            // Display the movie details using the movie object's toString method.
            System.out.println(movie);

            // Ask the user if they'd like to continue entering details for another movie.
            System.out.println("Do you want to enter another? (y or n)");
            choice = sc.nextLine();

        // Continue the loop as long as the user's choice is "y".
        } while(choice.equalsIgnoreCase("y"));

        // Print a goodbye message to the user.
        System.out.println("Goodbye");
    }
}

