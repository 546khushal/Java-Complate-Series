public class ArrayDeque {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize deque
    public ArrayDeque(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = 0;
        size = 0;
    }

    // Check if deque is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Insert at the front
    public void insertFront(int item) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = capacity - 1;
        } else {
            front--;
        }
        
        arr[front] = item;
        size++;
    }

    // Insert at the rear
    public void insertRear(int item) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == capacity - 1) {
            rear = 0;
        } else {
            rear++;
        }
        
        arr[rear] = item;
        size++;
    }

    // Delete from front
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == capacity - 1) {
            front = 0;
        } else {
            front++;
        }
        
        size--;
    }

    // Delete from rear
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear--;
        }
        
        size--;
    }

    // Get front element
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return arr[front];
    }

    // Get rear element
    public int getRear() {
        if (isEmpty() || rear < 0) {
            System.out.println("Deque is empty");
            return -1;
        }
        return arr[rear];
    }

    // Display deque elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        
        int i = front;
        System.out.print("Deque elements: ");
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    // Main method to test implementation
    public static void main(String[] args) {
        ArrayDeque deque = new ArrayDeque(5);
        
        deque.insertFront(10);
        deque.insertRear(20);
        deque.insertFront(5);
        deque.insertRear(25);
        
        deque.display(); // Output: 5 10 20 25
        
        System.out.println("Front element: " + deque.getFront()); // 5
        System.out.println("Rear element: " + deque.getRear()); // 25
        
        deque.deleteFront();
        deque.deleteRear();
        
        deque.display(); // Output: 10 20
        
        deque.insertFront(2);
        deque.insertRear(30);
        
        deque.display(); // Output: 2 10 20 30
    }
}