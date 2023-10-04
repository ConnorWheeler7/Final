package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SleepRecordsApplication extends Application {
    private HealthData healthData = new HealthData(); // Create an instance of HealthData
    private TextField hoursTextField;
    private Label averageLabel;
    private LineChart<Number, Number> sleepChart;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sleep Records Application");

        // Create a label, text field, and button for input
        Label label = new Label("Enter hours of sleep:");
        hoursTextField = new TextField();
        Button addButton = new Button("Add Sleep Record");

        // Create a label to display the average hours of sleep
        averageLabel = new Label("Average Hours of Sleep:");

        // Create a line chart to display sleep records
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        sleepChart = new LineChart<>(xAxis, yAxis);
        sleepChart.setTitle("Sleep Records Chart");

        // Create a layout for input components
        VBox inputLayout = new VBox(10);
        inputLayout.getChildren().addAll(label, hoursTextField, addButton, averageLabel);

        // Create a layout for the entire scene
        HBox layout = new HBox(10);
        layout.getChildren().addAll(inputLayout, sleepChart);

        // Define the action to be performed when the "Add Sleep Record" button is clicked
        addButton.setOnAction(e -> {
            addSleepRecord();
            updateAverageLabel();
            updateSleepChart();
        });

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(layout, 800, 400);
        primaryStage.setScene(scene);

        // Show the Stage
        primaryStage.show();
    }

    private void addSleepRecord() {
        String hoursText = hoursTextField.getText();
        try {
            double hours = Double.parseDouble(hoursText);
            healthData.addSleepRecord(hours); // Add the sleep record to HealthData
            hoursTextField.clear();
        } catch (NumberFormatException e) {
            // Handle invalid input
        }
    }

    private void updateAverageLabel() {
        double averageHours = healthData.calculateAverageHoursOfSleep();
        averageLabel.setText("Average Hours of Sleep: " + averageHours + " hours");
    }

    private void updateSleepChart() {
        ObservableList<XYChart.Series<Number, Number>> chartData = sleepChart.getData();
        if (chartData.isEmpty()) {
            // Create a new series if the chart is empty
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            series.setName("Sleep Records");
            chartData.add(series);
        }

        // Get the first (and only) series in the chart
        XYChart.Series<Number, Number> series = chartData.get(0);

        // Clear existing data
        series.getData().clear();

        // Add new data from sleep records
        double[] sleepRecords = healthData.getSleepRecords();
        for (int i = 0; i < sleepRecords.length; i++) {
            series.getData().add(new XYChart.Data<>(i + 1, sleepRecords[i]));
        }
    }
}
