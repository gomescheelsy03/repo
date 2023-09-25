import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMainPane extends VBox {
    
    // Declare buttons, label, text field, HBoxes, and DataManager
    private Button buttonHello;
    private Button buttonHowdy;
    private Button buttonChinese;
    private Button buttonClear;
    private Button buttonExit;
    private Button buttonBonjour;
    private Label feedbackLabel;
    private TextField textField;
    private HBox buttonBox;
    private HBox textFieldBox;
    private DataManager dataManager;

    // Constructor for the FXMainPane class
    public FXMainPane() {
        // Initialize the buttons with their respective labels
        buttonHello = new Button("Hello");
        buttonHowdy = new Button("Howdy");
        buttonChinese = new Button("Chinese");
        buttonClear = new Button("Clear");
        buttonExit = new Button("Exit");
        buttonBonjour = new Button("Bonjour");
        
        // Initialize the feedback label and text field
        feedbackLabel = new Label("Feedback:");
        textField = new TextField();
        
        // Initialize HBoxes with spacing for a more aesthetic look
        buttonBox = new HBox(10);
        textFieldBox = new HBox(10);

        // Add the buttons to the button HBox
        buttonBox.getChildren().addAll(buttonHello, buttonHowdy, buttonChinese, buttonClear, buttonExit, buttonBonjour);
        
        // Add the feedback label and text field to the text HBox
        textFieldBox.getChildren().addAll(feedbackLabel, textField);

        // Initialize the DataManager instance
        dataManager = new DataManager();
        
        // Create an instance of ButtonHandler to handle button actions
        ButtonHandler handler = new ButtonHandler();
        
        // Set action handlers for each button
        buttonHello.setOnAction(handler);
        buttonHowdy.setOnAction(handler);
        buttonChinese.setOnAction(handler);
        buttonClear.setOnAction(handler);
        buttonExit.setOnAction(handler);
        buttonBonjour.setOnAction(handler);

        // Define margins for buttons, label, and text field
        Insets inset = new Insets(10, 10, 10, 10);
        HBox.setMargin(buttonHello, inset);
        HBox.setMargin(buttonHowdy, inset);
        HBox.setMargin(buttonChinese, inset);
        HBox.setMargin(buttonClear, inset);
        HBox.setMargin(buttonExit, inset);
        HBox.setMargin(buttonBonjour, inset);
        HBox.setMargin(feedbackLabel, inset);
        HBox.setMargin(textField, inset);
        
        // Center-align the contents of the HBoxes
        buttonBox.setAlignment(Pos.CENTER);
        textFieldBox.setAlignment(Pos.CENTER);
        
        // Add HBoxes to the VBox (FXMainPane)
        getChildren().addAll(textFieldBox, buttonBox);
    }
    
    // Inner class to handle button click actions
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Check which button was clicked and perform the respective action
            if(event.getTarget() == buttonHello) {
                textField.setText(dataManager.getHello());
            } else if(event.getTarget() == buttonHowdy) {
                textField.setText(dataManager.getHowdy());
            } else if(event.getTarget() == buttonChinese) {
                textField.setText(dataManager.getChinese());
            } else if(event.getTarget() == buttonClear) {
                textField.setText("");
            } else if(event.getTarget() == buttonExit) {
                System.exit(0);
            } else if(event.getTarget() == buttonBonjour) {
                textField.setText(dataManager.getBonjour());
            }
        }
    }
}
