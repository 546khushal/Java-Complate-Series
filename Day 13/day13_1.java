/** Write a program to copy one file to other file using: 
1) Character by character 
2) Word by word 
3) Line by line  */
import java.io.*;
import java.util.Scanner;

public class java13_1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the source file name (with extension):");
        String sourceFile = scanner.nextLine();

        System.out.println("Enter the destination file name (with extension):");
        String destinationFile = scanner.nextLine();

        System.out.println("Choose the copy method:");
        System.out.println("1. Character by character");
        System.out.println("2. Word by word");
        System.out.println("3. Line by line");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                copyCharacterByCharacter(sourceFile, destinationFile);
                break;
            case 2:
                copyWordByWord(sourceFile, destinationFile);
                break;
            case 3:
                copyLineByLine(sourceFile, destinationFile);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    // Copy character by character
    private static void copyCharacterByCharacter(String source, String destination) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
            System.out.println("File copied character by character.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Copy word by word
    private static void copyWordByWord(String source, String destination) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words
                for (String word : words) {
                    writer.write(word + " ");
                }
            }
            System.out.println("File copied word by word.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Copy line by line
    private static void copyLineByLine(String source, String destination) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File copied line by line.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
