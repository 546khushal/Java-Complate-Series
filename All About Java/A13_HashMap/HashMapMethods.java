//unordered hai
//all in constant time O(1)
//hashMap dosn't allow duplicate key but allow duplicate value
//HashMap allow duplicate key also but only once and mutiple value

//Application of HashMaps
//1. Counting frequency of elements in an array
//2. Mapping problem
//3. Storage optimization
//4. Dictionary
//5. PhoneBook
//6. Caching




import java.util.*;
class HashMapMethods{
    public static void main(String[] args) {
        Map<String,Integer> mp  = new HashMap<>();
        mp.put("two", 2);
        mp.put("one", 1);
        mp.put("Eight",8);
        mp.put("Three",3);
        //Getting value of a key from the HashMap
        System.out.println(mp.get("one")); // prints 1
    
        //Changing the value of a key in the HashMap
        mp.put("one", 11);
        System.out.println(mp.get("one")); // prints 11

        //Removing a pair from the HashMap
        mp.remove("one");
        System.out.println(mp.get("one")); // prints null
        
        //checking of a l=key is in HashMap
        System.out.println(mp.containsKey("one")); // prints false

        //Adding a new Entru only if the new key is not already in the HashMap
        mp.putIfAbsent("one", 11);
        System.out.println(mp.get("one")); // prints 11

        //Get all keys from the HashMap
        System.out.println(mp.keySet()); // prints [Eight, one, two, Three]
        //get all values from the HashMap
        System.out.println(mp.values()); // prints [8, 11, 2, 3]

        //Get all entries from the HashMap
        System.out.println(mp.entrySet()); // prints [Eight=8, one=11, two=2, Three=3]

        //traversing all entries of HashMap -multiple methods
        for (String key : mp.keySet()){
            System.out.println(key+ " "+mp.get(key));
        }/**Eight 8
            one 11
            two 2
            Three 3 */
        for(Map.Entry<String,Integer> e: mp.entrySet()) {
            System.out.println(e.getKey()+ " "+e.getValue());
        }  /**Eight 8
            one 11
            two 2
            Three 3 */
        /*for(var e : mp.entrySet()){
            System.out.println(e.getKey()+ " "+e.getValue());
        } */
        

    }
}