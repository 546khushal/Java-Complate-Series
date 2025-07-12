public class LinkedListDeque {
    private static class Node {
        int data;
        Node prev;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public LinkedListDeque() {
        head = null;
        tail = null;
        size = 0;
    }
    
    // ========== ITERATIVE METHODS ==========
    
    public void addFirst(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addLast(int item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public int removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return data;
    }
    
    public int removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        int data = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return data;
    }
    
    // ========== RECURSIVE METHODS ==========
    
    /**
     * Recursive helper to add to front
     * Base case: current node is head (reached front)
     * Recursive case: move to previous node
     */
    private void addFirstRecursiveHelper(Node current, Node newNode) {
        if (current.prev == null) { // Base case
            current.prev = newNode;
            newNode.next = current;
            head = newNode;
        } else {
            addFirstRecursiveHelper(current.prev, newNode); // Recursive case
        }
    }
    
    public void addFirstRecursive(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            addFirstRecursiveHelper(head, newNode);
        }
        size++;
    }
    
    /**
     * Recursive helper to add to end
     * Base case: current node is tail (reached end)
     * Recursive case: move to next node
     */
    private void addLastRecursiveHelper(Node current, Node newNode) {
        if (current.next == null) { // Base case
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            addLastRecursiveHelper(current.next, newNode); // Recursive case
        }
    }
    
    public void addLastRecursive(int item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            addLastRecursiveHelper(tail, newNode);
        }
        size++;
    }
    
    // ========== UTILITY METHODS ==========
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void display() {
        Node current = head;
        System.out.print("Deque: [");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
    
    // ========== MAIN METHOD TO TEST ==========
    
    public static void main(String[] args) {
        LinkedListDeque deque = new LinkedListDeque();
        
        // Test iterative methods
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(25);
        deque.display(); // [5, 10, 20, 25]
        
        System.out.println("Removed first: " + deque.removeFirst()); // 5
        System.out.println("Removed last: " + deque.removeLast());   // 25
        deque.display(); // [10, 20]
        
        // Test recursive methods
        deque.addFirstRecursive(2);
        deque.addLastRecursive(30);
        deque.display(); // [2, 10, 20, 30]
        
        System.out.println("Size: " + deque.size()); // 4
        System.out.println("Is empty: " + deque.isEmpty()); // false
    }
}