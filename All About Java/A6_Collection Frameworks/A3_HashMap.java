/*
The HashMap is a part of the Java Collection(map interface) Framework and is used to store key-value pairs in an unsynchronized manner. 
It is one of the most commonly used data structures for fast data retrieval.
Key Characteristics
    Key-Value Pair:
        Data is stored in key-value pairs, where each key is unique, but values can be duplicate.
    Hashing Mechanism:
        Uses hashing to store and retrieve data efficiently. The hash code of the key is used to calculate the index for the bucket.
    Null Support:
        HashMap allows one null key and multiple null values. 

Method:-put(K key, V value),get(Object key),remove(Object key),containsKey(Object key),containsValue(Object value),
        isEmpty(),size(),keySet(),values(),entrySet()
 */

import java.util.HashMap;
class A2_HashMap{
    public static void main(String[] args){
         // Create a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Adding elements to the map
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.put(4, "Date");
        // Display the map
        System.out.println("HashMap: " + map);//HashMap: {1=Apple, 2=Banana, 3=Cherry, 4=Date}

        // Accessing a value
        System.out.println("Value for key 2: " + map.get(2));//Value for key 2: Banana

        // Checking for a key
        System.out.println("Contains key 3? " + map.containsKey(3));//Contains key 3? true

        // Checking for a value
        System.out.println("Contains value 'Banana'? " + map.containsValue("Banana"));//Contains value 'Banana'? true

        // Removing a key-value pair
        map.remove(1);
        System.out.println("HashMap after removing key 1: " + map);//HashMap after removing key 1: {2=Banana, 3=Cherry, 4=Date}

        // Iterating through the map
        System.out.println("Keys and Values:");
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
        /**
         * Keys and Values:
            Key: 2, Value: Banana
            Key: 3, Value: Cherry
            Key: 4, Value: Date
         */
    }
}

/**Synchronized ek mechanism hai Java me jo ensure karta hai ki ek shared resource (jaise variable, object, ya method) 
ko ek samay me sirf ek thread hi access kare. Isse multiple threads ke beech data inconsistency aur race condition avoid hoti hai. 
Example: HashTable, Vector
Synchronized kaise kaam karta hai?

    Jab ek thread synchronized block ya method me enter karta hai, toh wo resource ko lock kar leta hai (monitor lock).
    Jab tak ye thread synchronized block/method se bahar nahi aata, koi aur thread us resource ko access nahi kar sakta.
    Ek baar thread ka kaam khatam hone ke baad, lock release ho jata hai aur dusre thread ko resource access karne ka chance milta hai.

class SharedResource {
    synchronized void printNumbers() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500); // Delay simulate karne ke liye
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> resource.printNumbers(), "Thread-1");
        Thread t2 = new Thread(() -> resource.printNumbers(), "Thread-2");

        t1.start();
        t2.start();
    }
}
//output
Thread-1: 1
Thread-1: 2
Thread-1: 3
Thread-1: 4
Thread-1: 5
Thread-2: 1
Thread-2: 2
Thread-2: 3
Thread-2: 4
Thread-2: 5
Pehle Thread-1 complete karega, phir Thread-2 chalega, kyunki method synchronized hai.



Not Synchronized ka matlab hai ki ek resource ko multiple threads ek saath access kar 
    sakte hain, bina kisi restriction ke.
Example: ArrayList, HashMap
*/