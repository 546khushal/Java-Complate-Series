import java.util.Scanner;

class Queue {
    private static final int SIZE = 5; // Maximum size of the queue
    private int[] queue = new int[SIZE]; // Array to store queue elements
    private int front = -1; // Front pointer
    private int rear = -1; // Rear pointer

    // Display the menu
    static void menu() {
        System.out.println("\n-----Queue Operations-----");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Display");
        System.out.println("4. Exit");
        System.out.print("Enter Your Choice: ");
    }

    // Enqueue operation
    boolean enqueue(int value) {
        if (rear == SIZE - 1) {
            System.out.println("\nQueue is Overflow");
            return false;
        }
        if (front == -1) {
            front = 0;
        }
        queue[++rear] = value;
        return true;
    }

    // Dequeue operation
    int dequeue() {
        if (front == -1) {
            System.out.println("\nQueue is Underflow!");
            return -1;
        }
        int data = queue[front];
        if (front == rear) { // Reset if queue becomes empty
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return data;
    }

    // Display the queue
    void display() {
        if (front == -1 || front > rear) {
            System.out.println("\nQueue is Empty");
        } else {
            System.out.println("---Queue Elements---");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

public class QueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();
        int choice, value;

        do {
            Queue.menu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    value = scanner.nextInt();
                    if (queue.enqueue(value)) {
                        System.out.println("\nData Inserted Successfully");
                    }
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
