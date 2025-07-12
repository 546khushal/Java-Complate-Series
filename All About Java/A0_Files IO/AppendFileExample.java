import java.io.FileWriter;
import java.io.IOException;

public class AppendFileExample {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("sample.txt", true); // true = append mode
            writer.write("\nAppending new line to file.");
            writer.close();
            System.out.println("Data appended.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
