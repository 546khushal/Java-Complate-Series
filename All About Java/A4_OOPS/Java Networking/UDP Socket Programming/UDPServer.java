/**UDP (User Datagram Protocol)
Key Features:
    Connectionless: Pehle connection ki zaroorat nahi
    Unreliable: Delivery guarantee nahi
    No Ordering: Packets ka order maintain nahi hota
    No Error Correction: Bas basic error checking
    Lightweight: Kam system resources use karta
    Faster: Less overhead */
import java.net.*;
import java.io.*;  

public class UDPServer {
    public static void main(String[] args) throws IOException {
        // 9876 port par UDP socket banaya
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024]; // 1KB buffer
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
           
        System.out.println("Server started.");
       
        /*
            DatagramSocket - UDP connection ke liye
            9876 - Server ka port number
            receiveData - incoming messages store karne ke liye
        */

        while (true) {
            // Packet receive karne ke liye tayyar
            DatagramPacket receivePacket = 
                new DatagramPacket(receiveData, receiveData.length);
            
            // Client ka wait karega (blocking call)
            serverSocket.receive(receivePacket);
            
            /*
                receivePacket - client ka data store karega
                receive() - jab tak data nahi aata, rukega
            */

            // Bytes ko String mein convert kare
            String clientMessage = new String(receivePacket.getData());
            System.out.println("Client ne bheja: " + clientMessage.trim());
            
            // Client ka address aur port nikale
            InetAddress clientIP = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            
            /*
                getAddress() - client ka IP address
                getPort() - client ka port number
                Yeh dono response bhejne ke liye chahiye
            */

            /*// Response banaye (UPPERCASE mein)
            String response = clientMessage.toUpperCase();
            byte[] sendData = response.getBytes();
            */

           // Get server operator's response
            System.out.print("Server response likho: ");
            String response = serverInput.readLine();

            byte[] sendData = response.getBytes(); 
            // Response packet banaye
            DatagramPacket sendPacket = 
                new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
            
            // Client ko response bheje
            serverSocket.send(sendPacket);
            

            /*
                toUpperCase() - message ko capital letters mein convert karega
                getBytes() - String ko bytes mein convert karega
                send() - client ko response bhejega
            */
        }
    }
}