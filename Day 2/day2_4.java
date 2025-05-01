//Write a program to find the maximum from two numbers. (Without user input)
public class day2_5 {             //MaxOfTwoNumbers
    public static void main(String[] args) {
        int num1 = 25, num2 = 40;
        int max = (num1 > num2) ? num1 : num2; // Use ternary operator to find the maximum
        System.out.println("The maximum of " + num1 + " and " + num2 + " is: " + max);
    }
}
