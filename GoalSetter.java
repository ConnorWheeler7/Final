package application;

import java.util.Scanner;
class GoalSetter {
    private double goalWeight;

    public void setGoalWeight() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your goal weight: ");
        double newGoalWeight = scanner.nextDouble();

        if (newGoalWeight >= 0) {
            goalWeight = newGoalWeight;
            System.out.println("Goal weight set successfully.");
        } else {
            System.out.println("Invalid goal weight. Weight must be a non-negative number.");
        }
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public static double goalSettingProcess(double initialWeight) {
        GoalSetter goalSetter = new GoalSetter();
        goalSetter.setGoalWeight();

        // Retrieve and print the stored goal weight
        double storedGoalWeight = goalSetter.getGoalWeight();
        System.out.println("Goal weight: " + storedGoalWeight);

        // Calculate and display how many pounds to lose or gain
        double weightDifference = storedGoalWeight - initialWeight;
        if (weightDifference > 0) {
            System.out.println("You need to gain " + weightDifference + " pounds to reach your goal.");
        } else if (weightDifference < 0) {
            System.out.println("You need to lose " + (-weightDifference) + " pounds to reach your goal.");
        } else {
            System.out.println("Congratulations! You are already at your goal weight.");
        }
		return weightDifference;
    }
}