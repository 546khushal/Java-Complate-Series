/*
 * Assignment:
 * 1. Modify the Student class to jump from one constructor to another using constructor chaining.
 * 2. Test the constructors by creating objects and print the content of the objects.
 */

class day3_2 {
    private String name;
    private int age;

    // Default constructor
    public day3_2() {
        this("Unknown", 0); // Calls the parameterized constructor
    }

    // Parameterized constructor
    public day3_2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public day3_2(day3_2 other) {
        this(other.name, other.age); // Calls the parameterized constructor
    }

    // Method to display details of the student
    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        // Test the default constructor
        day3_2 student1 = new day3_2();
        System.out.println("Student 1 (Default Constructor):");
        student1.displayDetails();

        // Test the parameterized constructor
        day3_2 student2 = new day3_2("Alice", 25);
        System.out.println("\nStudent 2 (Parameterized Constructor):");
        student2.displayDetails();

        // Test the copy constructor
        day3_2 student3 = new day3_2(student2);
        System.out.println("\nStudent 3 (Copy Constructor):");
        student3.displayDetails();
    }
}
