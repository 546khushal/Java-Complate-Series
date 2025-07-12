import java.text.*;
import java.util.*;

public class DateFormatExample {
    public static void main(String[] args) {
        Date now = new Date();
        
        // Format date in default style
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Current date: " + sdf1.format(now));
        
        // Format with time
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss a");
        System.out.println("Current time: " + sdf2.format(now));
        
        // Format with full date/time
        SimpleDateFormat sdf3 = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' hh:mm a");
        System.out.println("Full format: " + sdf3.format(now));
        
        // Parse date from string
        try {
            Date parsedDate = sdf1.parse("2023-12-25");
            System.out.println("Parsed date: " + parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}