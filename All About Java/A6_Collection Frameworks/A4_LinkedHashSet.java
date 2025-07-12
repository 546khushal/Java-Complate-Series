/*
LinkedHashSet is a subclass of HashSet that maintains insertion order while still ensuring uniqueness of elements. 
It is part of the Java Collections Framework.
| Feature           | Description                                          |
| ----------------- | ---------------------------------------------------- |
| **Order**         | ✅ Maintains **insertion order**                      |
| **Duplicates**    | ❌ No duplicates allowed (like `HashSet`)             |
| **Null elements** | ✅ Allows **one null** element                        |
| **Thread-safe**   | ❌ Not synchronized                                   |
| **Performance**   | Slightly slower than `HashSet` due to order tracking |

 */
import java.util.*;

public class A4_LinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // Adding elements
        set.add("Banana");
        set.add("Apple");
        set.add("Orange");
        set.add("Mango");
        set.add("Apple"); // Duplicate, ignored
        set.add(null);    // One null is allowed

        System.out.println("LinkedHashSet elements:");
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // Check if an element exists
        System.out.println("Contains 'Mango'? " + set.contains("Mango"));

        // Remove an element
        set.remove("Orange");
        System.out.println("After removing 'Orange': " + set);

        // Set size
        System.out.println("Set size: " + set.size());
    }
}
