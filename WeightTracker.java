package application;

import java.util.Scanner;

public class WeightTracker {
    private double weight;

    public void inputWeight(double newWeight2) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the weight: ");
        double newWeight = scanner.nextDouble();

        if (newWeight >= 0) {
            weight = newWeight;
            System.out.println("Weight updated successfully.");
        } else {
            System.out.println("Invalid weight. Weight must be a non-negative number.");
        }
    }

    public double getWeight() {
        return weight;
    }

    public static void main(String[] args) {
        WeightTracker tracker = new WeightTracker();

        // Input and store the current weight
        tracker.getWeight();

        // Retrieve and print the stored weight
        double storedWeight = tracker.getWeight();
        System.out.println("Stored weight: " + storedWeight);

        // Now, let's navigate to the GoalSetter class
        GoalSetter.goalSettingProcess(storedWeight);
    }
} 