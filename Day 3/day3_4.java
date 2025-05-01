/*
 * Assignment:
 * 1. Modify the Book class to include default, parameterized, and copy constructors.
 * 2. Create three objects to test the above three constructors.
 * 3. Print the content of all three objects.
 */

class day3_4 {
    private String name;
    private String author;
    private double price;

    // Default Constructor
    public day3_4() {
        this.name = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        System.out.println("Default Constructor: Executed.");
    }

    // Parameterized Constructor
    public day3_4(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        System.out.println("Parameterized Constructor: Executed.");
    }

    // Copy Constructor
    public day3_4(day3_4 other) {
        this.name = other.name;
        this.author = other.author;
        this.price = other.price;
        System.out.println("Copy Constructor: Executed.");
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        // Create the first object using the default constructor
        System.out.println("\nCreating Book 1 (Default Constructor):");
        day3_4 book1 = new day3_4();
        book1.displayDetails();

        // Create the second object using the parameterized constructor
        System.out.println("\nCreating Book 2 (Parameterized Constructor):");
        day3_4 book2 = new day3_4("The Alchemist", "Paulo Coelho", 15.99);
        book2.displayDetails();

        // Create the third object using the copy constructor
        System.out.println("\nCreating Book 3 (Copy Constructor):");
        day3_4 book3 = new day3_4(book2);
        book3.displayDetails();
    }
}
