/*Write a program to create three objects of Book class(book name,  author , price). Write a method 
getDetails which takes user inputs (book name , author and price). Write other method name 
displayDetails to display the book name , author and price. Create three objects and test working of 
above two methods.*/
import java.util.Scanner;

class day2_d2 {
    // Attributes of the Book class
    private String bookName;
    private String author;
    private double price;

    // Method to get details from the user
    public void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book name: ");
        bookName = sc.nextLine();
        System.out.print("Enter author name: ");
        author = sc.nextLine();
        System.out.print("Enter price of the book: ");
        price = sc.nextDouble();
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        // Create three Book objects
        day2_d2 book1 = new day2_d2();
        day2_d2 book2 = new day2_d2();
        day2_d2 book3 = new day2_d2();

        // Get details for each book
        System.out.println("Enter details for Book 1:");
        book1.getDetails();
        System.out.println("\nEnter details for Book 2:");
        book2.getDetails();
        System.out.println("\nEnter details for Book 3:");
        book3.getDetails();

        // Display details for each book
        System.out.println("\nDetails of Book 1:");
        book1.displayDetails();
        System.out.println("\nDetails of Book 2:");
        book2.displayDetails();
        System.out.println("\nDetails of Book 3:");
        book3.displayDetails();
    }
}
