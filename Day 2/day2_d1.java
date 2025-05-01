/*Modify above Student class program to find the student having highest age among 3 students. */
import java.util.Scanner;

class day2_d1 {
    // Attributes
    private String name;
    private int age;

    // Method to get details from the user
    public void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter age: ");
        age = sc.nextInt();
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        // Create three Student objects
        day2_d1 student1 = new day2_d1();
        day2_d1 student2 = new day2_d1();
        day2_d1 student3 = new day2_d1();

        // Get details for each student
        System.out.println("Enter details for Student 1:");
        student1.getDetails();
        System.out.println("\nEnter details for Student 2:");
        student2.getDetails();
        System.out.println("\nEnter details for Student 3:");
        student3.getDetails();

        // Display details for each student
        System.out.println("\nDetails of Student 1:");
        student1.displayDetails();
        System.out.println("\nDetails of Student 2:");
        student2.displayDetails();
        System.out.println("\nDetails of Student 3:");
        student3.displayDetails();

        // Find the student with the highest age
        day2_d1 oldestStudent = student1;
        if (student2.getAge() > oldestStudent.getAge()) {
            oldestStudent = student2;
        }
        if (student3.getAge() > oldestStudent.getAge()) {
            oldestStudent = student3;
        }

        // Display the student with the highest age
        System.out.println("\nStudent with the highest age:");
        oldestStudent.displayDetails();
    }
}
