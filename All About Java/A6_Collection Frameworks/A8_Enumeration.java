/*Enumeration is an interface in Java, found in the java.util package. It provides a way to iterate through a collection of elements, particularly in legacy data structures like Vector and Hashtable.

Enumeration is considered a legacy interface and is mostly used with older collections like Vector and Hashtable

boolean hasMoreElements(): Checks if there are more elements to iterate over.

E nextElement(): Retrieves the next element in the enumeration.
Read-Only:
    Unlike Iterator, Enumeration does not allow removing elements from the collection during iteration.

 */
import java.util.Enumeration;
import java.util.Vector;
class A8_Enumeration{
    public static void main(String args[]) { 
        Enumeration days; 
        Vector dayNames = new Vector(); 
        dayNames.add("Sunday"); 
        dayNames.add("Monday"); 
        dayNames.add("Tuesday"); 
        dayNames.add("Wednesday"); 
        dayNames.add("Thursday"); 
        dayNames.add("Friday"); 
        dayNames.add("Saturday"); 
        days = dayNames.elements(); 
        while (days.hasMoreElements()) { 
        System.out.println(days.nextElement()); 
        
        } 
    }
    
} 
/*
Sunday
Monday
Tuesday
Wednesday
Thursday
Friday
Saturday */