/**TCP (Transmission Control Protocol)
Key Features:
    Connection-Oriented: Pehle connection establish karna padta hai (3-way handshake)
    Reliable Delivery: Data pakka pahunchta hai, nahi to error aata hai
    Ordered Delivery: Packets correct order mein pahunchte hain
    Error Checking: Automatic error detection aur correction
    Flow Control: Network congestion ko control karta hai
    Heavyweight: Zyada system resources use karta hai */

import java.net.*;//- Networking related classes ke liye (ServerSocket, Socket etc.)
import java.io.*;// Input/Output operations ke liye (BufferedReader, PrintWriter etc.)

public class TCPServer {
    public static void main(String[] args) throws IOException {
        // Create server socket listening on port 6789
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server started. Waiting for client...");
        /*
            ServerSocket - Client connections accept karne ke liye
            Port 6789 par listen karega
            Message print karega ki server start ho gaya hai */


        // Accept client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");
        /*
            accept() - Client ka wait karega (blocking call)
            Jab client connect karega, Socket object return karega
            "Client connected" message print karega
         */


        // Create input/output streams
        BufferedReader in = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        /**
            BufferedReader - Client se data read karne ke liye
            PrintWriter - Client ko data send karne ke liye
            true - Auto-flush enable karta hai (immediate sending)
         */


        // Read from client and send response
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            out.println("Server echoes: " + inputLine);
        }
        /*
            readLine() - Client se data read karega (line by line)
            Jab tak client data send karta rahega (null nahi aata)
            Received message print karega
            Client ko echo response send karega ("Server echoes: " + original message)
         */
        // Close connections
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}/*
   1. Server start hota hai aur port 6789 par listen karta hai
   2. Client connect hone ka wait karta hai
   3. Client connect hone par connection establish hota hai
   4. Server client se messages receive karta hai
   5. Har message ka echo response send karta hai
   6. Client disconnect karne par server close ho jata hai 
   
Output:   Server Console
Server started. Waiting for client...
Client connected
Received: Hello
Received: How are you?

Client Console(Example):
Hello
Server echoes: Hello
How are you?
Server echoes: How are you?
   */