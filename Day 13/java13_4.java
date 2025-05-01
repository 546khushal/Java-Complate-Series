/**Write a program which will take one word from user which is supposed to be find in the file. Find the 
word in that file and display the list of indexed (position) of that word in that file.  */
import java.io.*;
import java.util.*;

public class java13_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the file to search in: ");
        String fileName = scanner.nextLine();

        System.out.print("Enter the word to search for: ");
        String wordToSearch = scanner.nextLine();

        List<Integer> indexes = new ArrayList<>();
        int position = 0; // Tracks the overall position in the file

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split the line into words using whitespace as delimiter
                for (String word : words) {
                    if (word.equals(wordToSearch)) {
                        indexes.add(position);
                    }
                    position++;
                }
            }

            if (indexes.isEmpty()) {
                System.out.println("The word \"" + wordToSearch + "\" was not found in the file.");
            } else {
                System.out.println("The word \"" + wordToSearch + "\" was found at the following positions: " + indexes);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        scanner.close();
    }
}
