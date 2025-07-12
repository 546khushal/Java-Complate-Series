/*Java Hashtable class implements a hashtable, which maps keys to values. It inherits Dictionary 
class and implements the Map interface.

The HashTable is a part of the Java Collection Framework and is used to store key-value pairs in a synchronized manner. 
It is similar to HashMap, but it has its own unique characteristics and is thread-safe.

The important points about Java Hashtable class are: 
 
            A Hashtable is an array of list. Each list is known as a bucket. The position of bucket is 
            identified by calling the hashcode() method. A Hashtable contains values based on the 
            key. 
            It contains only unique elements. 
            It may have not have any null key or value. 
            It is synchronized. 

 declaration for java.util.Hashtable class.
Mthods:-put(K key, V value), get(Object key),remove(Object key),containsKey(Object key),containsValue(Object value)
        isEmpty(),size(),keys(),elements()

public class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>, Cloneable, Ser 
ializable 
    K: It is the type of keys maintained by this map. 
    V: It is the type of mapped values. 

 */
import java.util.Hashtable;
public class A3_HashTable{
    public static void main(String[] args){
        //Creating a hashTable
        Hashtable<Integer, String> table = new Hashtable<>();

        //Adding key-value pairs
        table.put(1,"Apple");
        table.put(2,"Banana");
        table.put(3,"Cherry");

        //Display the HashTable
        System.out.println("Initial HashTable: "+ table);//Initial HashTable: {3=Cherry, 2=Banana, 1=Apple}
        /*
        
        HashTable ka Behavior:
            HashTable keys ko internally hash code ke basis par store karta hai.
            Iska data insertion order maintain nahi hota.
            Isliye jab aap HashTable ke elements ko print karte ho, toh keys arbitrary order me dikhayi deti hain (e.g., {3=Cherry, 2=Banana, 1=Apple}).
        HashMap ka Behavior:
            HashMap bhi keys ko hash code ke basis par store karta hai aur insertion order maintain nahi karta.
            Agar aapko HashMap me elements insertion order me chahiye, toh aap LinkedHashMap ka use karte hain.



        Why Different Output Order for HashTable and HashMap?
            HashTable aur HashMap dono ka internal implementation hash-based hai, lekin:
                    HashTable ka hashing algorithm aur internal table resizing strategy alag hai.
                    Dono classes ka bucket management implementation different hai.
            Is wajah se, order of keys print karte waqt vary karta hai.
            Lekin ye important hai ki:
                Dono classes me data retrieval keys ke hash code par depend karta hai, na ki insertion order par.
         */
        
        
        // Accessing a value
        System.out.println("Value for key 2: " + table.get(2));//Value for key 2: Banana

        // Checking for a key
        System.out.println("Contains key 3? " + table.containsKey(3));//Contains key 3? true

        // Checking for a value
        System.out.println("Contains value 'Grapes'? " + table.containsValue("Grapes"));//Contains value 'Grapes'? false

        // Removing a key-value pair
        table.remove(1);
        System.out.println("HashTable after removing key 1: " + table);//HashTable after removing key 1: {3=Cherry, 2=Banana}

         // Iterating through keys and values
        System.out.println("Keys and Values:");
        for (Integer key : table.keySet()) {
            System.out.println("Key: " + key + ", Value: " + table.get(key));
        }
        /*
        Keys and Values:
        Key: 3, Value: Cherry
        Key: 2, Value: Banana
         */
    
    }

}
/*
| Feature              | **HashTable**                               | **HashMap**                                       |
| -------------------- | ------------------------------------------- | ------------------------------------------------- |
| **Thread Safety**    | Synchronized (thread-safe).                 | Not synchronized.                                 |
| **Performance**      | Slower due to synchronization overhead.     | Faster in single-threaded environments.           |
| **Null Keys/Values** | Does not allow `null` keys or values.       | Allows one `null` key and multiple `null` values. |
| **Modern Usage**     | Legacy class, not recommended for new code. | Preferred in modern Java applications.            |


 */
