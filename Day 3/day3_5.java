/*
 * Assignment:
 * Modify the Book class to jump from the parameterized constructor to the default constructor.
 * Test and execute the program.
 */

class day3_5 {
    private String name;
    private String author;
    private double price;

    // Default Constructor
    public day3_5() {
        this.name = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        System.out.println("Default Constructor: Executed.");
    }

    // Parameterized Constructor
    public day3_5(String name, String author, double price) {
        this(); // Jump to the default constructor
        System.out.println("Back to Parameterized Constructor: Executing additional steps.");
        this.name = name;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        // Create an object using the parameterized constructor
        System.out.println("\nCreating Book (Parameterized Constructor calling Default Constructor):");
        day3_5 book = new day3_5("The Alchemist", "Paulo Coelho", 15.99);
        book.displayDetails();
    }
}
