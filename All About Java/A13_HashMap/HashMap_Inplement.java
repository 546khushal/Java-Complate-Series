/**
 * Custom HashMap implementation with basic operations:
 * put(), get(), remove(), and size()
 */
class HashMap_Implement {
    
    /**
     * The main HashMap class implementing key-value storage
     * @param <K> Type of keys
     * @param <V> Type of values
     */
    static class MyHashMap<K, V> {
        // Default initial capacity of the HashMap
        public static final int DEFAULT_CAPACITY = 4;
        // Load factor threshold for resizing
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;
        
        /**
         * Node class to store key-value pairs
         */
        private class Node {
            K key;
            V value;
            
            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        
        private int n; // Number of entries in the map
        private LinkedList<Node>[] buckets; // Array of linked lists (buckets)
        
        /**
         * Initializes the bucket array with given size
         * @param N The capacity/size of bucket array
         */
        private void initBuckets(int N) {
            buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }
        
        /**
         * Computes the hash value for a key
         * @param key The key to hash
         * @return The bucket index for this key
         */
        private int hashFunc(K key) {
            int hc = key.hashCode();
            return (Math.abs(hc)) % buckets.length;
        }
        
        /**
         * Searches for a key in a specific bucket (linked list)
         * @param llist The linked list to search in
         * @param key The key to search for
         * @return Index of the node if found, -1 otherwise
         */
        private int searchInBucket(LinkedList<Node> llist, K key) {
            for (int i = 0; i < llist.size(); i++) {
                if (llist.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }
        
        /**
         * Rehashes the map when load factor exceeds threshold
         */
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            initBuckets(oldBuckets.length * 2);
            n = 0;
            
            for (LinkedList<Node> bucket : oldBuckets) {
                for (Node node : bucket) {
                    put(node.key, node.value);
                }
            }
        }
        
        // Constructor
        public MyHashMap() {
            initBuckets(DEFAULT_CAPACITY);
        }
        
        /**
         * @return The number of entries in the HashMap
         */
        public int size() {
            return n;
        }
        
        /**
         * Inserts or updates a key-value pair
         * @param key The key to insert/update
         * @param value The value to associate with the key
         */
        public void put(K key, V value) {
            int bi = hashFunc(key); // Bucket index
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key); // Entry index
            
            if (ei == -1) { // Key doesn't exist - insert new node
                Node node = new Node(key, value);
                currBucket.add(node);
                n++;
            } else { // Key exists - update value
                Node currNode = currBucket.get(ei);
                currNode.value = value;
            }
            
            // Check if rehashing is needed
            if (n > buckets.length * DEFAULT_LOAD_FACTOR) {
                rehash();
            }
        }
        
        /**
         * Gets the value associated with a key
         * @param key The key to search for
         * @return The value if key exists, null otherwise
         */
        public V get(K key) {
            int bi = hashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            
            if (ei != -1) {
                Node currNode = currBucket.get(ei);
                return currNode.value;
            }
            return null;
        }
        
        /**
         * Removes a key-value pair from the map
         * @param key The key to remove
         * @return The removed value if key existed, null otherwise
         */
        public V remove(K key) {
            int bi = hashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            
            if (ei != -1) {
                Node node = currBucket.remove(ei);
                n--;
                return node.value;
            }
            return null;
        }
    }
    
    public static void main(String[] args) {
        // Test the HashMap implementation
        MyHashMap<String, Integer> mp = new MyHashMap<>();
        
        // Put some values
        mp.put("Alice", 25);
        mp.put("Bob", 30);
        mp.put("Charlie", 35);
        
        // Test get()
        System.out.println("Alice's age: " + mp.get("Alice")); // 25
        System.out.println("Bob's age: " + mp.get("Bob"));     // 30
        
        // Test update
        mp.put("Alice", 26);
        System.out.println("Updated Alice's age: " + mp.get("Alice")); // 26
        
        // Test remove
        System.out.println("Removed Charlie: " + mp.remove("Charlie")); // 35
        System.out.println("Size after removal: " + mp.size()); // 2
        
        // Test non-existent key
        System.out.println("David's age: " + mp.get("David")); // null
    }
}