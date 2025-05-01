// Test nested exception by putting exception handling mechanism in the above method and also in main method. 

import java.util.Scanner;

public class day8_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            try {
                System.out.print("Enter Student Age: ");
                int age = scanner.nextInt();

                // Create student with nested validation
                StudentWithSetter student = new StudentWithSetter(id, name);
                student.setAge(age);
                student.display();
            } catch (InvalidAgeException e) {
                System.out.println("Nested Exception - Error: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Outer Exception - Unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Desirable Assignment 4: Nested exception handling completed.");
        }
    }
}
