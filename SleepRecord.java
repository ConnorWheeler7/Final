package application;
import java.util.Scanner;

public class SleepRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of sleep records you want to input: ");
        int numRecords = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create an array to store sleep records
        double[] sleepRecords = new double[numRecords];

        // Input and store sleep records
        for (int i = 0; i < numRecords; i++) {
            System.out.print("Enter hours of sleep for record #" + (i + 1) + ": ");
            double hoursOfSleep = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            sleepRecords[i] = hoursOfSleep;
        }

        // Print stored sleep records
        System.out.println("Sleep Records:");
        for (int i = 0; i < numRecords; i++) {
            System.out.println("Record #" + (i + 1) + ": " + sleepRecords[i] + " hours of sleep");
        }

        // Close the scanner when done to release resources
        scanner.close();
    }
}



