/*
| Feature            | `HashSet`       | `HashMap`                    | `Hashtable`        |
| ------------------ | --------------- | ---------------------------- | ------------------ |
| Stores             | Unique elements | Key-value pairs              | Key-value pairs    |
| Null key/value     | 1 null key      | 1 null key, many null values | ❌ No nulls allowed |
| Thread-safe        | ❌ No            | ❌ No                      | ✅ Yes              |
| Allows duplicates  | ❌ No            | ❌ Keys, ✅ Values        | ❌ Keys, ✅ Values   |
| Maintains order    | ❌ No            | ❌ No                      | ❌ No               |
| Internal structure | Uses `HashMap`  | Uses hash table              | Uses hash table    |
| Performance        | Fast (O(1) avg) | Fast (O(1) avg)              | Slower due to sync |

 */

import java.util.*;

public class A4_HashSet {
    public static void main(String[] args) {
        // Creating a HashSet of Strings
        HashSet<String> fruits = new HashSet<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Banana"); // duplicate, will not be added

        System.out.println("Fruits set: " + fruits);

        // Check if a value exists
        if (fruits.contains("Mango")) {
            System.out.println("Mango is in the set.");
        }

        // Remove an element
        fruits.remove("Apple");
        System.out.println("After removing Apple: " + fruits);

        // Set size
        System.out.println("Set size: " + fruits.size());

        // Iterate over the set
        System.out.println("Iterating over set:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Clear the set
        fruits.clear();
        System.out.println("Set after clear(): " + fruits);
    }
}
