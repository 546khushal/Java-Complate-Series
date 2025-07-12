public class CircularSinglyLinkedList {
    private Node head;
    private int size;

    // Node class
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public CircularSinglyLinkedList() {
        head = null;
        size = 0;
    }

    // 1. Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            newNode.next = newNode; // Points to itself
            head = newNode;
        } else {
            newNode.next = head;
            
            // Find the last node to update its next pointer
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            last.next = newNode;
            head = newNode;
        }
        size++;
    }

    // 2. Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            last.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    // 3. Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        if (head.next == head) { // Only one node
            head = null;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            head = head.next;
            last.next = head;
        }
        size--;
    }

    // 4. Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        if (head.next == head) { // Only one node
            head = null;
        } else {
            Node current = head;
            Node prev = null;
            
            while (current.next != head) {
                prev = current;
                current = current.next;
            }
            
            prev.next = head;
        }
        size--;
    }

    // 5. Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }

    // 6. Get size
    public int size() {
        return size;
    }

    // 7. Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // 8. Search for an element
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
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        
        System.out.println("Inserting at beginning:");
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.display(); // 10 -> 20 -> 30 -> (head)
        
        System.out.println("\nInserting at end:");
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.display(); // 10 -> 20 -> 30 -> 40 -> 50 -> (head)
        
        System.out.println("\nDeleting from beginning:");
        list.deleteFromBeginning();
        list.display(); // 20 -> 30 -> 40 -> 50 -> (head)
        
        System.out.println("\nDeleting from end:");
        list.deleteFromEnd();
        list.display(); // 20 -> 30 -> 40 -> (head)
        
        System.out.println("\nList size: " + list.size());
        System.out.println("Is 30 in list? " + list.contains(30));
        System.out.println("Is 100 in list? " + list.contains(100));
    }
}