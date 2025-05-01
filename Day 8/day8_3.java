// Modify the above program of Student Class by taking the age from user using method. 

import java.util.Scanner;

class StudentWithSetter {
    private int id;
    private String name;
    private int age;

    // Constructor
    public StudentWithSetter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to set age with validation
    public void setAge(int age) throws InvalidAgeException {
        if (age < 20) {
            throw new InvalidAgeException("Age must be at least 20 years.");
        }
        this.age = age;
    }

    // Display student details
    public void display() {
        System.out.println("Student ID: " + id + ", Name: " + name + ", Age: " + age);
    }
}

public class day8_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student Age: ");
            int age = scanner.nextInt();

            // Create student and set age
            StudentWithSetter student = new StudentWithSetter(id, name);
            student.setAge(age);
            student.display();
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
