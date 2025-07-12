/*
ArrayList and Vector both implements List interface and maintains insertion order. 
+----------------------+----------------------------+-----------------------------+
| Feature              | ArrayList                 | Vector                      |
+----------------------+----------------------------+-----------------------------+
| Package              | java.util                 | java.util                   |
+----------------------+----------------------------+-----------------------------+
| Synchronization      | Not synchronized          | Synchronized                |
|                      | Faster but not thread-safe| Slower but thread-safe      |
+----------------------+----------------------------+-----------------------------+
| Performance          | Better for single-threaded| Slower due to synchronization|
|                      | applications              |                             |
+----------------------+----------------------------+-----------------------------+
| Growth Policy        | Increases by 50% of the   | Doubles its size when full  |
|                      | current capacity          |                             |
+----------------------+----------------------------+-----------------------------+
| Legacy or Modern     | Part of modern Java       | Legacy class (from JDK 1.0) |
|                      | (introduced in JDK 1.2)   |                             |
+----------------------+----------------------------+-----------------------------+
| Iteration            | Faster iteration using    | Supports Enumeration and    |
|                      | `Iterator`               | `Iterator`                  |
+----------------------+----------------------------+-----------------------------+
| Usage Recommendation | Preferred for new         | Rarely used in modern       |
|                      | applications              | development                 |
+----------------------+----------------------------+-----------------------------+
| Fail-Fast Behavior   | Iterators are fail-fast   | Enumeration is not fail-fast|
|                      | (throws ConcurrentModificationException)|                |
+----------------------+----------------------------+-----------------------------+
| Default Size         | 10                        | 10                          |
+----------------------+----------------------------+-----------------------------+
| Methods              | Contains modern utility   | Contains legacy methods like|
|                      | methods, e.g., `add()`,   | `addElement()`              |
|                      | `remove()`, etc.          |                             |
+----------------------+----------------------------+-----------------------------+
| Thread-Safety        | Requires manual handling  | Built-in thread safety      |
|                      | using `Collections.synchronizedList()`|                 |
+----------------------+----------------------------+-----------------------------+

 */
import java.util.*;
class A2_Vector{
    public static void main(String[] args){
        // Using ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("** ArrayList Demo **");
        
        // Adding elements
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println("ArrayList: " + arrayList);//ArrayList: [Apple, Banana, Cherry]
        
        // Accessing an element
        System.out.println("Element at index 1 (ArrayList): " + arrayList.get(1));//Element at index 1 (ArrayList): Banana
        
        // Removing an element
        arrayList.remove("Banana");
        System.out.println("ArrayList after removing 'Banana': " + arrayList);//ArrayList after removing 'Banana': [Apple, Cherry]
        
        // Iterating using a for-each loop
        System.out.println("Iterating through ArrayList:");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }
        /**Iterating through ArrayList:
            Apple
            Cherry */



//**************************************************

        // Using Vector
        Vector<String> vector = new Vector<>();
        System.out.println("\n** Vector Demo **");
        
        // Adding elements
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");
        System.out.println("Vector: " + vector);//Vector: [Apple, Banana, Cherry]
        
        // Accessing an element
        System.out.println("Element at index 1 (Vector): " + vector.get(1));//Element at index 1 (Vector): Banana
        
        // Removing an element
        vector.remove("Banana");
        System.out.println("Vector after removing 'Banana': " + vector);//Vector after removing 'Banana': [Apple, Cherry]
        
        // Iterating using a for-each loop
        System.out.println("Iterating through Vector:");
        for (String fruit : vector) {
            System.out.println(fruit);
        }
        /*Iterating through Vector:
            Apple
            Cherry */
        
        // Demonstrating synchronization in Vector
        System.out.println("\n** Synchronization in Vector **");
        System.out.println("Adding elements to Vector from multiple threads...");
        
        Thread t1 = new Thread(() -> vector.add("Date"));
        Thread t2 = new Thread(() -> vector.add("Elderberry"));
        
        t1.start();
        t2.start();
        
        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Vector after multithreaded operations: " + vector);//Vector after multithreaded operations: [Apple, Cherry, Date, Elderberry]
        
        // Demonstrating capacity behavior
        System.out.println("\n** Capacity Behavior **");
        System.out.println("ArrayList initial size: " + arrayList.size());//ArrayList initial size: 2
        System.out.println("Vector initial size: " + vector.size());//Vector initial size: 4
        System.out.println("Vector capacity: " + vector.capacity());//Vector capacity: 10
        

        System.out.println("\nAdding more elements to Vector...");
        for (int i = 0; i < 15; i++) {
            vector.add("Element " + i);
        }
        System.out.println("Vector after adding elements: " + vector);//Vector after adding elements: [Apple, Cherry, Date, Elderberry, Element 0, Element 1, Element 2, Element 3, Element 4, Element 5, Element 6, Element 7, Element 8, Element 9, Element 10, Element 11, Element 12, Element 13, Element 14]
        System.out.println("New Vector capacity: " + vector.capacity());//New Vector capacity: 20



    }
}

