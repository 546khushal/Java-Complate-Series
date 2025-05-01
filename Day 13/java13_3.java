/**Write a program to reverse the content of the file. File name must be given by user. */
import java.io.*;
import java.util.Scanner;

public class java13_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the file to reverse: ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter the name of the output file: ");
        String outputFile = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Read the entire content of the file into a StringBuilder
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }

            // Reverse the content
            content.reverse();

            // Write the reversed content to the output file
            writer.write(content.toString());

            System.out.println("File content reversed successfully. Output written to: " + outputFile);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
