import java.net.*; // Networking ke liye jaruri classes (Socket, ServerSocket)
import java.io.*;  // Data read-write karne ke liye streams

public class TCPClient {
    public static void main(String[] args) throws IOException {
        // Server se connect kre (localhost or port 6789 pr)
        Socket socket = new Socket("localhost", 6789);
        System.out.println("Server se connected!");
        /*
            Socket - Server se connection banane ke liye
            "localhost" matlab apna hi computer
            6789 - wahi port number jo server use kar raha hai
            "Server se connected!" - confirmation message
         */
        // Input/Output streams banaye
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(
            new InputStreamReader(System.in));
        /**
            PrintWriter - Server ko messages bhejne ke liye
            BufferedReader(in) - Server se replies padhne ke liye  
            BufferedReader(stdIn) - Keyboard se input lene ke liye
            true - Auto-flush (messages turant bhej dega)
         */

        // User se input le or server pr bheje
        System.out.println("Koi bhi message type karo (Exit ke liye Ctrl+C):");
        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput); // Server ko message bhejo
            System.out.println("Server ka jwab: " + in.readLine()); // Response print karo
        }
        /*
            readLine() - User ka input lega (har line ke baad Enter dabane par)
            null - Jab user program band karega
            out.println() - Server ko message bhejega
            in.readLine() - Server ka reply sunega
         */

        // close connections
        out.close();
        in.close();
        stdIn.close();
        socket.close();
        /*
            Har stream aur socket ko properly band karna zaroori hai
            System resources free honge
         */
    }
}
/*
Program ka Flow:
1. Server se connection establish karega
2. User se input lega aur server ko bhejega
3. Server ka reply show karega
4. Ye process tab tak chalti rahegi jab tak user Ctrl+C na dabaye

Output Example:
Server se connected!
Koi bhi message type karo (Exit ke liye Ctrl+C):
Hello
Server ka jwab: Server*/