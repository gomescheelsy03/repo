/**
 * The MovieDriver class serves as a driver program to collect and display 
 * information about a movie using the Movie class.
 */
import java.util.Scanner;

public class MovieDriver_Task1 {

    /**
     * The main method of the MovieDriver class.
     * @param args command-line arguments (unused in this context)
     */
    public static void main(String[] args) {

        // Initialize a Scanner object to read user input.
        Scanner sc = new Scanner(System.in);

        // Create a new Movie object.
        Movie movie = new Movie();

        // Prompt and read the title of the movie from the user.
        System.out.println("Enter the name of a movie");
        movie.setTitle(sc.nextLine());

        // Prompt and read the rating of the movie from the user.
        System.out.println("Enter the rating of the movie");
        movie.setRating(sc.nextLine());

        // Prompt and read the number of tickets sold for the movie from the user.
        System.out.println("Enter the number of tickets sold for this movie");
        movie.setSoldTickets(sc.nextInt());

        // Display the details of the movie.
        System.out.println(movie);

        // End the program with a goodbye message.
        System.out.println("Goodbye");
    }
}
