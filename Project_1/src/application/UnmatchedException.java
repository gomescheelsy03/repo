package application;

public class UnmatchedException extends Exception {
    public UnmatchedException() {
        // Ensure the message matches exactly what the test expects
        super("Passwords do not match");
    }
}
