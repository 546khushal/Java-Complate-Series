/*
 * Essential Assignment:
 * 1. Modify the Student class to add default, parameterized, and copy constructors.
 * 2. Create three objects of the Student class to test the above three constructors.
 * 3. Print the content of all the three objects.
 */

class day3_1 {
    private String name;
    private int age;

    // Default constructor
    public day3_1() {
        this.name = "Unknown"; // Default name
        this.age = 0;          // Default age
    }

    // Parameterized constructor
    public day3_1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public day3_1(day3_1 other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display details of the student
    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        // Test the default constructor
        day3_1 student1 = new day3_1();
        System.out.println("Student 1 (Default Constructor):");
        student1.displayDetails();

        // Test the parameterized constructor
        day3_1 student2 = new day3_1("John", 20);
        System.out.println("\nStudent 2 (Parameterized Constructor):");
        student2.displayDetails();

        // Test the copy constructor
        day3_1 student3 = new day3_1(student2);
        System.out.println("\nStudent 3 (Copy Constructor):");
        student3.displayDetails();
    }
}
