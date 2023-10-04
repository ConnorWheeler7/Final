package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Application");

        // Create buttons to open Weight Tracker and Sleep Records applications
        Button weightTrackerButton = new Button("Open Weight Tracker");
        Button sleepRecordsButton = new Button("Open Sleep Records");

        // Define actions for the Weight Tracker button
        weightTrackerButton.setOnAction(e -> {
            WeightTrackerApplication weightTrackerApp = new WeightTrackerApplication();
            weightTrackerApp.start(new Stage());
        });

        // Define actions for the Sleep Records button
        sleepRecordsButton.setOnAction(e -> {
            SleepRecordsApplication sleepRecordsApp = new SleepRecordsApplication();
            sleepRecordsApp.start(new Stage());
        });

        // Create a layout for buttons
        VBox buttonLayout = new VBox(10);
        buttonLayout.getChildren().addAll(weightTrackerButton, sleepRecordsButton);

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(buttonLayout, 300, 200);
        primaryStage.setScene(scene);

        // Show the Stage
        primaryStage.show();
    }
}
