/**Write the program to marge two files in to third file using any of the above approaches.  */
import java.io.*;

public class java13_2 {
    public static void main(String[] args) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader("file1.txt"));
             BufferedReader reader2 = new BufferedReader(new FileReader("file2.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("mergedFile.txt"))) {

            // Merge content of the first file
            String line;
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Maintain line separation
            }

            // Merge content of the second file
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Maintain line separation
            }

            System.out.println("Files merged successfully into 'mergedFile.txt'.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
