/**Modify the above program-1 and provide the searching facility by using name and age. If multiple 
students found, display all the student’s information one by one.   */
import java.io.*;
import java.util.Scanner;

// Student class definition
class Student implements Serializable {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Age: " + age;
    }
}

public class day14_2{

    // Write students to a binary file
    public static void writeStudentsToFile(String filename) {
        Student[] students = new Student[] {
            new Student(1, "Alice", 20),
            new Student(2, "Bob", 21),
            new Student(3, "Charlie", 22),
            new Student(4, "David", 23),
            new Student(5, "Eva", 24)
        };

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Student student : students) {
                out.writeObject(student); // Write each student to the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Search for students by name or age and display them
    public static void searchStudentsByNameOrAge(String filename, String name, int age) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            boolean found = false;
            while (true) {
                try {
                    Student student = (Student) in.readObject();
                    // Check if the student's name matches or if the age matches
                    if ((name != null && student.name.equalsIgnoreCase(name)) || student.age == age) {
                        System.out.println("Found Student: " + student);
                        found = true;
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            if (!found) {
                System.out.println("No student found with the given name or age.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "students.dat";
        writeStudentsToFile(filename); // Write the student data to file

        // Ask the user for search criteria
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search by: ");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice == 1) {
            System.out.print("Enter name to search: ");
            String name = scanner.nextLine();
            searchStudentsByNameOrAge(filename, name, -1);  // -1 means ignore age in search
        } else if (choice == 2) {
            System.out.print("Enter age to search: ");
            int age = scanner.nextInt();
            searchStudentsByNameOrAge(filename, null, age);
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
