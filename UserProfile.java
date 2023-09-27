package application;
import java.util.Scanner;

public class UserProfile {
    private String name;
    private int age;
    private String gender;
    private String contactInfo;

    public UserProfile(String name, int age, String gender, String contactInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contactInfo;
    }

    // Getters and setters for each field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        System.out.print("Enter your gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter your contact information: ");
        String contactInfo = scanner.nextLine();

        UserProfile userProfile = new UserProfile(name, age, gender, contactInfo);

        // Display user information
        System.out.println("User Information:");
        System.out.println("Name: " + userProfile.getName());
        System.out.println("Age: " + userProfile.getAge());
        System.out.println("Gender: " + userProfile.getGender());
        System.out.println("Contact Info: " + userProfile.getContactInfo());
    }
}