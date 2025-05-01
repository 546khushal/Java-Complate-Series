/**Create Student class(Id,name,age). Put appropriate constructor to initialize all the data member of the 
class. Write 5 objects to the file. Id of the student must be 1,2,3,4 and 5. User will provide the Id of the 
student, and your program will display the information of that student.   */
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

public class day14_1 {

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

    // Search for a student by Id
    public static void searchStudentById(String filename, int studentId) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            boolean found = false;
            while (true) {
                try {
                    Student student = (Student) in.readObject();
                    if (student.id == studentId) {
                        System.out.println("Student Found: " + student);
                        found = true;
                        break;
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            if (!found) {
                System.out.println("Student with Id " + studentId + " not found.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "students.dat";
        writeStudentsToFile(filename); // Write the student data to file

        // Ask the user to input the student id to search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student Id to search: ");
        int studentId = scanner.nextInt();
        searchStudentById(filename, studentId);
    }
}
