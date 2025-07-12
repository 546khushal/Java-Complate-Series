import java.io.*;
import java.util.Scanner;

public class FileHandlingExample {

    private static final String FILE_NAME = "example.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nFile Handling Options:");
            System.out.println("1. Create a file");
            System.out.println("2. Write to the file");
            System.out.println("3. Read from the file");
            System.out.println("4. Append to the file");
            System.out.println("5. Delete the file");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createFile();
                    break;
                case 2:
                    System.out.print("Enter text to write to the file: ");
                    String contentToWrite = scanner.nextLine();
                    writeToFile(contentToWrite);
                    break;
                case 3:
                    readFromFile();
                    break;
                case 4:
                    System.out.print("Enter text to append to the file: ");
                    String contentToAppend = scanner.nextLine();
                    appendToFile(contentToAppend);
                    break;
                case 5:
                    deleteFile();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createFile() {
        try {
            File file = new File(FILE_NAME);
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    private static void writeToFile(String content) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(content);
            System.out.println("Content written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    private static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    private static void appendToFile(String content) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(content + System.lineSeparator());
            System.out.println("Content appended to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }
    }

    private static void deleteFile() {
        File file = new File(FILE_NAME);
        if (file.delete()) {
            System.out.println("File deleted successfully: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
