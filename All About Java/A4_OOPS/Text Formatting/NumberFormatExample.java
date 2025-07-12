import java.text.*;
import java.util.*;

public class NumberFormatExample {
    public static void main(String[] args) {
        double number = 12345.6789;
        Locale locale = new Locale("en", "US");
        
        // Number formatting
        NumberFormat nf = NumberFormat.getInstance(locale);
        System.out.println("Number: " + nf.format(number));
        
        // Currency formatting
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        System.out.println("Currency: " + cf.format(number));
        
        // Percentage formatting
        NumberFormat pf = NumberFormat.getPercentInstance(locale);
        System.out.println("Percent: " + pf.format(0.75));
        
        // Decimal formatting with pattern
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Custom format: " + df.format(number));
    }
}