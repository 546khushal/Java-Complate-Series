// Write a program to perform addition of two given numbers and display its answer. (With user input)
import java.util.Scanner;

public class day2_2 {         //AdditionWithInput
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        int sum = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
        sc.close();
    }
}
