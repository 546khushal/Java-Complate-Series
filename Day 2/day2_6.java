/*
 Write a program to create three objects of Student class(name, age). Write getDetails method which 
takes user inputs (name and age). Write other method named displayDetails to display the name and 
age of the user. Create three objects and test working of above two methods.
 */
import java.util.Scanner;

class day2_6 {     //Student
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

    public static void main(String[] args) {
        // Create three Student objects
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

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
    }
}
