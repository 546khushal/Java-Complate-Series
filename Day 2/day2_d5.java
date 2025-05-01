/*Write a program for calculator using switch case for addition & subtractions operations. */ 
import java.util.Scanner;

class day1_d5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the first number
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        // Input the second number
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        // Input the operation choice
        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        double result;

        // Switch case to perform the selected operation
        switch (choice) {
            case 1: // Addition
                result = num1 + num2;
                System.out.println("The result of addition is: " + result);
                break;

            case 2: // Subtraction
                result = num1 - num2;
                System.out.println("The result of subtraction is: " + result);
                break;

            default: // Invalid choice
                System.out.println("Invalid choice! Please select 1 or 2.");
        }

        scanner.close(); // Close the scanner
    }
}
