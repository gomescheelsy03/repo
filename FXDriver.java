import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXDriver is the main entry point for the JavaFX application.
 * It sets up the initial scene and displays the GUI.
 */
public class FXDriver extends Application {
    
    /**
     * The main method which launches the JavaFX application.
     * 
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        launch(args);  // Launch the JavaFX application
    }
    
    /**
     * The start method sets up the initial stage and scene for the application.
     * It gets called after the JavaFX application is launched.
     * 
     * @param stage the primary stage on which the scene is set.
     * @throws IOException in case of input/output errors.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Instantiate the main pane which holds all the GUI components.
        FXMainPane root = new FXMainPane();

        // Set the scene on the stage with the main pane as root and set dimensions.
        stage.setScene(new Scene(root, 500, 250));

        // Set the title for the stage.
        stage.setTitle("Hello World GUI");

        // Display the stage to the user.
        stage.show();
    }
}
