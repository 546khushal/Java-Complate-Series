/*
 * Assignment:
 * 1. Modify the Student class to include an initializer block and a static block.
 * 2. Test the default, parameterized, and copy constructors to ensure the initializer and static blocks are executed correctly.
 */

class day3_3 {
    private String name;
    private int age;

    // Static block: Executes once when the class is loaded
    static {
        System.out.println("Static Block: Class Student is loaded.");
    }

    // Initializer block: Executes before any constructor
    {
        System.out.println("Initializer Block: A new Student object is being created.");
        name = "Default Name"; // Setting default name
        age = -1; // Setting default age
    }

    // Default constructor
    public day3_3() {
        this("Unknown", 0); // Calls the parameterized constructor
        System.out.println("Default Constructor: Executed.");
    }

    // Parameterized constructor
    public day3_3(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterized Constructor: Executed.");
    }

    // Copy constructor
    public day3_3(day3_3 other) {
        this(other.name, other.age); // Calls the parameterized constructor
        System.out.println("Copy Constructor: Executed.");
    }

    // Method to display details of the student
    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        // Create the first object using the default constructor
        System.out.println("\nCreating Student 1 (Default Constructor):");
        day3_3 student1 = new day3_3();
        student1.displayDetails();

        // Create the second object using the parameterized constructor
        System.out.println("\nCreating Student 2 (Parameterized Constructor):");
        day3_3 student2 = new day3_3("Alice", 25);
        student2.displayDetails();

        // Create the third object using the copy constructor
        System.out.println("\nCreating Student 3 (Copy Constructor):");
        day3_3 student3 = new day3_3(student2);
        student3.displayDetails();
    }
}
