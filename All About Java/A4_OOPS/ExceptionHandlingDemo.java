/**
 * EXCEPTION HANDLING IN JAVA
 * 
 * What is exception 
        In java, exception is an event that disrupts the normal flow of the program. It is an object which is 
        thrown at runtime. 

 * Definition:
 * Exception handling is a mechanism to handle runtime errors such as 
 * ClassNotFoundException, IOException, SQLException, RemoteException, etc.
 * 
 * Key Concepts:
 * 1. Exception: An unwanted or unexpected event that disrupts the normal flow 
 *    of the program.
 * 2. Error: Represents serious problems that a reasonable application should 
 *    not try to catch (e.g., OutOfMemoryError).
 * 
 * Hierarchy:
 * Throwable (root class)
 *   ├── Error (unchecked)
 *   └── Exception
 *       ├── RuntimeException (unchecked)
 *       └── Other Exceptions (checked)
 * 
 * Types:
 * 1. Checked Exceptions: Checked at compile-time (must be handled or declared)e.g.IOException, SQLException etc.
             Checked exceptions wo exceptions hain jo compile time par check hoti hain. Agar koi method checked exception throw karta hai, to ya to usse try-catch block me handle karna padta hai ya phir method signature me throws keyword ke sath declare karna padta hai.
 * 2. Unchecked Exceptions: Not checked at compile-time (RuntimeException and its subclasses) e.g. ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException etc. 
            Unchecked exceptions wo exceptions hain jo runtime par hoti hain, aur inhe handle karna optional hota hai. Ye mostly aapke code me logical error ya bugs ki wajah se hoti hain.
 * 3. Errors: Serious problems beyond application control
 * 
 * Keywords:
 * - try: Contains code that might throw exceptions
 * - catch: Handles the exception
 * - finally: Always executes (for cleanup)
 * - throw: Throws an exception explicitly
 * - throws: Declares exceptions that might be thrown
 */
public class ExceptionHandlingDemo {

    /**
     * METHOD TO DEMONSTRATE BASIC TRY-CATCH BLOCK
     * 
     * This shows how to catch an ArithmeticException (unchecked exception)
     * that occurs when dividing by zero.
     */
    public static void basicTryCatch() {
        try {
            int result = 10 / 0; // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
    }

    /**
     * METHOD TO DEMONSTRATE MULTIPLE CATCH BLOCKS
     * 
     * Multiple catch blocks can be used to handle different types of exceptions.
     * The order should be from most specific to most general.
     */
    public static void multipleCatchBlocks() {
        try {
            int[] arr = new int[5];
            arr[10] = 50; // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught generic Exception: " + e.getMessage());
        }
    }

    /**
     * METHOD TO DEMONSTRATE FINALLY BLOCK
     * 
     * The finally block always executes whether an exception occurs or not.
     * It's typically used for cleanup code (closing files, database connections, etc.).
     */
    public static void finallyBlockDemo() {
        try {
            int result = 100 / 5; // No exception here
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            System.out.println("This is finally block - always executes");
        }
    }

    /**
     * METHOD TO DEMONSTRATE THROW KEYWORD
     * 
     * The throw keyword is used to explicitly throw an exception.
     * Here we throw a custom exception when age is invalid.
     */
    public static void validateAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Age must be at least 18");
        } else {
            System.out.println("Age is valid");
        }
    }

    /**
     * METHOD TO DEMONSTRATE THROWS KEYWORD
     * 
     * The throws keyword declares exceptions that might be thrown by the method.
     * Callers must handle or declare these exceptions.
     * 
     * @throws IOException if there's an I/O error
     */
    public static void readFile() throws IOException {
        // Simulating file reading operation
        throw new IOException("File not found");
    }

    /**
     * METHOD TO DEMONSTRATE CUSTOM EXCEPTION
     * 
     * Creating and using a custom exception by extending Exception class.
     */
    public static void customExceptionDemo() throws InvalidAgeException {
        int age = -5;
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Basic Try-Catch Demo ===");
        basicTryCatch();
        
        System.out.println("\n=== Multiple Catch Blocks Demo ===");
        multipleCatchBlocks();
        
        System.out.println("\n=== Finally Block Demo ===");
        finallyBlockDemo();
        
        System.out.println("\n=== Throw Keyword Demo ===");
        try {
            validateAge(15);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        System.out.println("\n=== Throws Keyword Demo ===");
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
        
        System.out.println("\n=== Custom Exception Demo ===");
        try {
            customExceptionDemo();
        } catch (InvalidAgeException e) {
            System.out.println("Caught InvalidAgeException: " + e.getMessage());
        }
    }
}

/**
 * CUSTOM EXCEPTION CLASS
 * 
 * Custom exceptions should typically extend Exception (checked) or 
 * RuntimeException (unchecked) depending on requirements.
 */
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}