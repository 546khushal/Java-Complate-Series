import java.io.Console;

class ConsoleClass {
    public static void main(String[] args) {
        Console c = System.console();

        if (c == null) {
            System.out.println("No console available.");
            return;
        }

        System.out.print("Enter your name: ");
        String n = c.readLine();
        System.out.println("Welcome " + n);
    }
}
