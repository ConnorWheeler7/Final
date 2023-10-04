package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeightTrackerApplication extends Application {
    private double storedWeight;
    private double goalWeight;
    private Label resultLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weight Tracker Application");

        // Create a label to display results
        resultLabel = new Label("");

        // Create text fields for weight input and goal input
        TextField weightTextField = new TextField();
        weightTextField.setPromptText("Enter weight");

        TextField goalTextField = new TextField();
        goalTextField.setPromptText("Enter goal weight");

        // Create a button for storing weight
        Button storeWeightButton = new Button("Store Weight");

        // Create a button for storing goal weight
        Button storeGoalButton = new Button("Store Goal Weight");

        // Define the action to be performed when the "Store Weight" button is clicked
        storeWeightButton.setOnAction(e -> {
            // Retrieve the weight entered by the user
            String weightInput = weightTextField.getText();

            try {
                storedWeight = Double.parseDouble(weightInput);

                // Display the stored weight
                resultLabel.setText("Stored weight: " + storedWeight);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid weight input. Please enter a valid number.");
            }
        });

        // Define the action to be performed when the "Store Goal Weight" button is clicked
        storeGoalButton.setOnAction(e -> {
            // Retrieve the goal weight entered by the user
            String goalInput = goalTextField.getText();

            try {
                goalWeight = Double.parseDouble(goalInput);

                // Calculate the difference between stored weight and goal weight
                double difference = goalWeight - storedWeight;

                // Determine whether to gain or lose based on the sign of the difference
                String gainOrLose = (difference > 0) ? "You need to gain" : "You need to lose";

                // Display the goal result
                resultLabel.setText(gainOrLose + " " + Math.abs(difference) + " pounds to reach your goal.");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid goal weight input. Please enter a valid number.");
            }
        });

        // Create a layout for input components
        VBox inputLayout = new VBox(10);
        inputLayout.getChildren().addAll(weightTextField, storeWeightButton, goalTextField, storeGoalButton);

        // Create a layout for the entire scene
        StackPane layout = new StackPane();
        layout.getChildren().addAll(inputLayout, resultLabel);

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);

        // Show the Stage
        primaryStage.show();
    }
}
