import java.util.Scanner;

class CircularQueue {
    private static final int SIZE = 5;
    private int[] queue;
    private int front, rear;

    // Constructor
    public CircularQueue() {
        queue = new int[SIZE];
        front = -1;
        rear = -1;
    }

    // Enqueue: Add an element to the queue
    public boolean enqueue(int value) {
        if ((rear == SIZE - 1 && front == 0) || (rear + 1 == front)) {
            System.out.println("\nQueue is Overflow");
            return false;
        }
        if (front == -1) { // Initially, the queue is empty
            front = rear = 0;
        } else if (rear == SIZE - 1 && front != 0) { // Wrap around to the beginning
            rear = 0;
        } else {
            rear++;
        }
        queue[rear] = value;
        return true;
    }

    // Dequeue: Remove an element from the queue
    public int dequeue() {
        if (front == -1) { // Queue is empty
            System.out.println("\nQueue is Underflow!");
            return -9999; // Special value to indicate underflow
        }
        int data = queue[front];
        queue[front] = 0; // Optional: Clear the spot for better visualization

        if (front == rear) { // Only one element was in the queue
            front = rear = -1;
        } else if (front == SIZE - 1) { // Wrap around to the beginning
            front = 0;
        } else {
            front++;
        }
        return data;
    }

    // Display the queue
    public void display() {
        if (front == -1) {
            System.out.println("\nQueue is Empty");
            return;
        }

        System.out.println("---Queue Elements---");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break; // Stop when we reach the rear
            i++;
            if (i == SIZE) i = 0; // Wrap around to the beginning
        }
        System.out.println();
    }
}

public class CircularQueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularQueue queue = new CircularQueue();
        int choice, value;

        do {
            System.out.println("\n-----Queue Operations-----");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("\nEnter Your Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Element to insert: ");
                    value = scanner.nextInt();
                    if (queue.enqueue(value)) {
                        System.out.println("\nData Inserted Successfully");
                    }
                    break;

                case 2:
                    value = queue.dequeue();
                    if (value != -9999) {
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
        } while (choice != 4);

        scanner.close();
    }
}
