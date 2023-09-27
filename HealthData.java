package application;

public class HealthData {
    private double[] sleepRecords;

    public void SleepDataAnalyzer(double[] sleepRecords) {
        this.sleepRecords = sleepRecords;
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
