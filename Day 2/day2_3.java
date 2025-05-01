// Write a program to perform addition of numbers between 3 to 10 using for loop.
public class day2_3{      //AdditionUsingLoop 
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 3; i <= 10; i++) {
            sum += i; // Add current number to sum
        }
        System.out.println("The sum of numbers from 3 to 10 is: " + sum);
    }
}
