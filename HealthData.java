package application;

public class HealthData {
    private double[] sleepRecords;

    public HealthData() {
        // Initialize the sleepRecords array with an empty array
        this.sleepRecords = new double[0];
    }

    // Method to add a sleep record to the array
    public void addSleepRecord(double hours) {
        double[] newSleepRecords = new double[sleepRecords.length + 1];
        System.arraycopy(sleepRecords, 0, newSleepRecords, 0, sleepRecords.length);
        newSleepRecords[sleepRecords.length] = hours;
        sleepRecords = newSleepRecords;
    }

    // Method to calculate the average hours of sleep
    public double calculateAverageHoursOfSleep() {
        if (sleepRecords.length == 0) {
            return 0.0; // Handle the case when there are no sleep records to avoid division by zero.
        }

        double totalHoursOfSleep = 0.0;
        for (double hours : sleepRecords) {
            totalHoursOfSleep += hours;
        }

        return totalHoursOfSleep / sleepRecords.length;
    }

    // Other methods for data analysis can be added here.

    // Getters and setters for sleepRecords if needed

    public double[] getSleepRecords() {
        return sleepRecords;
    }

    public void setSleepRecords(double[] sleepRecords) {
        this.sleepRecords = sleepRecords;
    }
}