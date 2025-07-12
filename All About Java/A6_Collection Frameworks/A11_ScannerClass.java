/*
The Scanner class in Java, part of the java.
util package, is used for reading input from various sources, including the console, files, and strings. 
It provides a simple and convenient way to parse primitive types and strings.
| Method                         | Description                                        |
| ------------------------------ | -------------------------------------------------- |
| `next()`                       | Reads the next token as a `String`.                |
| `nextLine()`                   | Reads the entire line as a `String`.               |
| `nextInt()`                    | Reads the next token as an `int`.                  |
| `nextDouble()`                 | Reads the next token as a `double`.                |
| `nextBoolean()`                | Reads the next token as a `boolean`.               |
| `hasNext()`                    | Returns `true` if there are more tokens available. |
| `hasNextInt()`                 | Checks if the next token is an `int`.              |
| `useDelimiter(String pattern)` | Sets a custom delimiter.                           |

 */

import java.util.Scanner;

public class A11_ScannerClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object

        // Using nextLine() to read a full line
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();
        System.out.println("You entered (full line): " + sentence);

        sc.nextLine();
        // Using next() to read a single word
        System.out.println("\nEnter a single word:");
        String word = sc.next();
        System.out.println("You entered (single word): " + word);
        sc.nextLine();
        
        // Using nextInt() to read an integer
        System.out.println("\nEnter an integer:");
        int integerValue = sc.nextInt();
        System.out.println("You entered (integer): " + integerValue);

        // Using nextDouble() to read a decimal number
        System.out.println("\nEnter a decimal number:");
        double doubleValue = sc.nextDouble();
        System.out.println("You entered (decimal): " + doubleValue);

        // Using nextBoolean() to read a boolean value
        System.out.println("\nEnter true or false:");
        boolean booleanValue = sc.nextBoolean();
        System.out.println("You entered (boolean): " + booleanValue);

        // Checking if there's more input using hasNext()
        System.out.println("\nEnter more words or numbers (type 'exit' to stop):");
        while (sc.hasNext()) {
            String token = sc.next();
            if (token.equalsIgnoreCase("exit")) break; // Stop if the input is "exit"
            System.out.println("You entered (token): " + token);
        }

        // Demonstrating useDelimiter()
        System.out.println("\nDemonstrating custom delimiter (comma-separated values):");
        System.out.println("Enter comma-separated values (e.g., apple,banana,cherry):");
        sc.useDelimiter(","); // Set custom delimiter to comma (,)
        while (sc.hasNext()) {
            String token = sc.next().trim();
            System.out.println("Token: " + token);
        }

        // Resetting to default delimiter (whitespace)
        //sc.useDelimiter("\\s+");

        // Demonstrating hasNextInt(), hasNextDouble(), hasNextBoolean()
        System.out.println("\nEnter different types of values (integer, decimal, boolean, or text):");
        if (sc.hasNextInt()) {
            System.out.println("Detected an integer: " + sc.nextInt());
        } else if (sc.hasNextDouble()) {
            System.out.println("Detected a double: " + sc.nextDouble());
        } else if (sc.hasNextBoolean()) {
            System.out.println("Detected a boolean: " + sc.nextBoolean());
        } else if (sc.hasNext()) {
            System.out.println("Detected a string: " + sc.next());
        }

        sc.close(); // Close the scanner
        System.out.println("\nScanner closed. Program finished.");
    }
}
