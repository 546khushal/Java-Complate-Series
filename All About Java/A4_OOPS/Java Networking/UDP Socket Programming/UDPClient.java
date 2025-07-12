import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        // User input ke liye tayyar
        BufferedReader userInput = 
            new BufferedReader(new InputStreamReader(System.in));
        
        /*
            BufferedReader - keyboard se input lene ke liye
            System.in - standard input stream
        */

        // Client socket banaya
        DatagramSocket clientSocket = new DatagramSocket();
        
        // Server ka address (localhost matlab same computer)
        InetAddress serverIP = InetAddress.getByName("localhost");
        
        /*
            DatagramSocket - UDP connection ke liye
            getByName("localhost") - 127.0.0.1 IP address
        */

        byte[] sendData;
        byte[] receiveData = new byte[1024]; // 1KB buffer
    while(true) {
        // User se message input le
        System.out.print("Apna message likho (exit ke liye 'bye' likho): ");
        String message = userInput.readLine(); 
        // Check for exit condition
            if(message.equalsIgnoreCase("bye")) {
                System.out.println("Connection closing...");
                break;
            }
        
        sendData = message.getBytes();
        
        /*
            readLine() - user ka input lega
            getBytes() - String ko bytes mein convert karega
        */

        // Server ko packet bheje
        DatagramPacket sendPacket = 
            new DatagramPacket(sendData, sendData.length, serverIP, 9876);
        clientSocket.send(sendPacket);
        
        /*
            9876 - server ka port number
            send() - packet server ko bhejega
        */

        // Server se response ka wait kare
        DatagramPacket receivePacket = 
            new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        
        /*
            receive() - server ka response aane tak rukega
            receivePacket - server ka response store karega
        */

        // Response ko print kare
        String serverResponse = new String(receivePacket.getData());
        System.out.println("Server ka reply: " + serverResponse.trim());
    }
        /// Close resources
        clientSocket.close();
        userInput.close();
        System.out.println("Connection closed.");
        
        /*
            trim() - extra whitespace hatayega
            close() - connection band karega
        */
    }
}