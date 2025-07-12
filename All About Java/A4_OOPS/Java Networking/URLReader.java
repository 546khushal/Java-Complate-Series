import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.example.com");
        /*     URL class ka object banaya
            "https://www.example.com" - Hum is website ka content padhenge
            Aap kisi bhi website ka URL daal sakte hain*/            
        // Read directly from URL
        BufferedReader in = new BufferedReader(
            new InputStreamReader(url.openStream()));
        /*
            url.openStream() - Website se connection banata hai
            InputStreamReader - Bytes ko characters mein convert karta hai
            BufferedReader - Efficient reading ke liye */


        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        /**    Har line ko padhkar screen pe print karega
            readLine() null return karega jab content khatam ho jayega
            Poora webpage ka HTML code print hoga */
        in.close();
        
        // URL connection with more control
        URLConnection connection = url.openConnection();
        /**    URLConnection - Advanced features ke liye
                Header information, content type etc. access kar sakte hain */
        System.out.println("Content-Type: " + connection.getContentType());
        System.out.println("Content-Length: " + connection.getContentLength());
        /**    getContentType() - File type batayega (e.g., text/html)
        getContentLength() - Content ka size bytes mein batayega */
    }
}