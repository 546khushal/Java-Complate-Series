//  Handling ArrayIndexOutOfBoundsException and DivideByZeroException

public class day8_1 {
    public static void main(String[] args) {
        // Handling ArrayIndexOutOfBoundsException and DivideByZeroException
        try {
            int[] arr = {1, 2, 3};
            System.out.println("Accessing an out-of-bounds index: " + arr[5]); // Will cause ArrayIndexOutOfBoundsException
            int result = 10 / 0; // Will cause DivideByZeroException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds!");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed!");
        } finally {
            System.out.println("Essential Assignment 1: Exception handling demonstration completed.");
        }
    }
}
