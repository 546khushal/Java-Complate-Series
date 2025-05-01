/*
 * Assignment:
 * Add initializer and static blocks to the program.
 * Check the execution sequence of the initializer block, static block, and constructors.
 */

class day3_6 {
    private String name;
    private String author;
    private double price;

    // Static Block
    static {
        System.out.println("Static Block: Executed first when the class is loaded.");
    }

    // Initializer Block
    {
        System.out.println("Initializer Block: Executed before each constructor.");
        name = "Default Book";
        author = "Default Author";
        price = 0.0;
    }

    // Default Constructor
    public day3_6() {
        System.out.println("Default Constructor: Executed after the Initializer Block.");
    }

    // Parameterized Constructor
    public day3_6(String name, String author, double price) {
        this(); // Jump to the default constructor
        System.out.println("Back to Parameterized Constructor: Assigning values.");
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
        System.out.println("Creating Book 1 (Default Constructor):");
        day3_6 book1 = new day3_6();
        book1.displayDetails();

        System.out.println("\nCreating Book 2 (Parameterized Constructor):");
        day3_6 book2 = new day3_6("The Alchemist", "Paulo Coelho", 15.99);
        book2.displayDetails();
    }
}
