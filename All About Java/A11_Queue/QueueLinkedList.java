import java.util.Scanner;

class Node {
    int data; // Data stored in the node
    Node next; // Reference to the next node

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private Node front; // Front of the queue
    private Node rear; // Rear of the queue

    // Constructor
    Queue() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue operation: Add an element to the end of the queue
    void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) { // If queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("\nData Inserted Successfully");
    }

    // Dequeue operation: Remove and return the front element
    int dequeue() {
        if (front == null) { // If queue is empty
            System.out.println("\nQueue is Underflow!");
            return -1;
        }

        int data = front.data;
        front = front.next;

        if (front == null) { // If the queue becomes empty
            rear = null;
        }

        return data;
    }

    // Display the queue
    void display() {
        if (front == null) { // If queue is empty
            System.out.println("\nQueue is Empty");
            return;
        }

        System.out.println("---Queue Elements---");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class QueueLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();
        int choice, value;

        do {
            System.out.println("\n-----Queue Operations-----");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    value = scanner.nextInt();
                    queue.enqueue(value);
                    break;

                case 2:
                    value = queue.dequeue();
                    if (value != -1) {
                        System.out.println("\nDeleted element is: " + value);
                    }
                    break;

                case 3:
                    queue.display();
                    break;

                case 4:
                    System.out.println("\nBye Bye!");
                    break;

                default:
                    System.out.println("\nInvalid Choice!");
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine(); // Consume newline
            scanner.nextLine(); // Wait for Enter
        } while (choice != 4);

        scanner.close();
    }
}
