/**Create Student class(Id,name,age). Put appropriate constructor to initialize all the data member of the 
class. Write 5 objects to the file. Id of the student must be 1,2,3,4 and 5. User will provide the Id of the 
student, and your program will display the information of that student.   */
import java.io.*;
import java.util.Scanner;

class Student implements Serializable {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }
}

public class day15_1 {
    public static void main(String[] args) {
        String fileName = "students.dat";

        // Writing 5 students to the file
        writeStudentsToFile(fileName);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student ID to search: ");
        int searchId = scanner.nextInt();

        // Reading and searching for the student by ID
        searchStudentById(fileName, searchId);

        scanner.close();
    }

    private static void writeStudentsToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(new Student(1, "Alice", 20));
            oos.writeObject(new Student(2, "Bob", 22));
            oos.writeObject(new Student(3, "Charlie", 21));
            oos.writeObject(new Student(4, "Diana", 23));
            oos.writeObject(new Student(5, "Eve", 20));
            System.out.println("Student data written to file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void searchStudentById(String fileName, int searchId) {
        boolean found = false; // Declare found outside the try block
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                Student student = (Student) ois.readObject();
                if (student.getId() == searchId) {
                    System.out.println("Student found:");
                    student.display();
                    found = true;
                    break;
                }
            }
        } catch (EOFException e) {
            // Handle end of file
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }
    }
}
