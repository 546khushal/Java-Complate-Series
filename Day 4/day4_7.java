// Calculator program to perform addition, subtraction, multiplication, and division of two integers, floats, and doubles using method overloading and static methods
class day4_7 {
    // Addition methods
    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    // Subtraction methods
    public static int subtract(int a, int b) {
        return a - b;
    }

    public static float subtract(float a, float b) {
        return a - b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication methods
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static float multiply(float a, float b) {
        return a * b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    // Division methods
    public static int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero is not allowed.");
        return a / b;
    }

    public static float divide(float a, float b) {
        if (b == 0) throw new ArithmeticException("Division by zero is not allowed.");
        return a / b;
    }

    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero is not allowed.");
        return a / b;
    }

    public static void main(String[] args) {
        // Testing integer operations
        System.out.println("Addition of integers: " + add(10, 5));
        System.out.println("Subtraction of integers: " + subtract(10, 5));
        System.out.println("Multiplication of integers: " + multiply(10, 5));
        System.out.println("Division of integers: " + divide(10, 5));

        // Testing float operations
        System.out.println("Addition of floats: " + add(10.5f, 5.5f));
        System.out.println("Subtraction of floats: " + subtract(10.5f, 5.5f));
        System.out.println("Multiplication of floats: " + multiply(10.5f, 5.5f));
        System.out.println("Division of floats: " + divide(10.5f, 5.5f));

        // Testing double operations
        System.out.println("Addition of doubles: " + add(10.5, 5.5));
        System.out.println("Subtraction of doubles: " + subtract(10.5, 5.5));
        System.out.println("Multiplication of doubles: " + multiply(10.5, 5.5));
        System.out.println("Division of doubles: " + divide(10.5, 5.5));
    }
}
