public class CircularDoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    // Node class
    private static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Constructor
    public CircularDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // 1. Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    // 2. Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }

    // 3. Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }

    // 4. Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
    }

    // 5. Display the list (forward)
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }

    // 6. Display the list (backward)
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = tail;
        do {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        } while (current != tail);
        System.out.println("(tail)");
    }

    // 7. Get size
    public int size() {
        return size;
    }

    // 8. Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // 9. Search for an element
    public boolean contains(int data) {
        if (head == null) return false;
        
        Node current = head;
        do {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        } while (current != head);
        
        return false;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        
        System.out.println("Inserting at beginning:");
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.displayForward(); // 10 <-> 20 <-> 30 <-> (head)
        
        System.out.println("\nInserting at end:");
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.displayForward(); // 10 <-> 20 <-> 30 <-> 40 <-> 50 <-> (head)
        
        System.out.println("\nDisplaying backward:");
        list.displayBackward(); // 50 <-> 40 <-> 30 <-> 20 <-> 10 <-> (tail)
        
        System.out.println("\nDeleting from beginning:");
        list.deleteFromBeginning();
        list.displayForward(); // 20 <-> 30 <-> 40 <-> 50 <-> (head)
        
        System.out.println("\nDeleting from end:");
        list.deleteFromEnd();
        list.displayForward(); // 20 <-> 30 <-> 40 <-> (head)
        
        System.out.println("\nList size: " + list.size());
        System.out.println("Is 30 in list? " + list.contains(30));
        System.out.println("Is 100 in list? " + list.contains(100));
    }
}