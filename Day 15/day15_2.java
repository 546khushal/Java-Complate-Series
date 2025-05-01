/**Modify the above program-1 and provide the searching facility by using name and age. If multiple 
students found, display all the student’s information one by one.   */
import java.io.*;
import java.util.Scanner;

public class day15_2 {
    public static void main(String[] args) {
        String fileName = "students.dat";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Search by: 1. Name  2. Age");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 : {
                System.out.print("Enter the name to search: ");
                scanner.nextLine(); // Consume newline
                String name = scanner.nextLine();
                searchStudentByName(fileName, name);
            }
            case 2 : {
                System.out.print("Enter the age to search: ");
                int age = scanner.nextInt();
                searchStudentByAge(fileName, age);
            }
            default : System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    private static void searchStudentByName(String fileName, String name) {
        boolean found = false; // Declare found outside the try block
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                Student student = (Student) ois.readObject();
                if (student.getName().equalsIgnoreCase(name)) {
                    student.display();
                    found = true;
                }
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        if (!found) {
            System.out.println("No students with name '" + name + "' found.");
        }
    }

    private static void searchStudentByAge(String fileName, int age) {
        boolean found = false; // Declare found outside the try block
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                Student student = (Student) ois.readObject();
                if (student.getAge() == age) {
                    student.display();
                    found = true;
                }
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        if (!found) {
            System.out.println("No students with age " + age + " found.");
        }
    }
}
