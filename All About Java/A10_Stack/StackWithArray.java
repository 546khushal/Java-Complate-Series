import java.util.Scanner;

class StackWithArray {
    private int[] stackArray;
    private int top;
    private int capacity;

    // Constructor to initialize stack
    public StackWithArray(int size) {
        stackArray = new int[size];
        capacity = size;
        top = -1; // Stack is initially empty
    }

    // Push operation to add element to stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
        } else {
            stackArray[++top] = value;
            System.out.println(value + " pushed to stack");
        }
    }

    // Pop operation to remove element from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        } else {
            int value = stackArray[top--];
            System.out.println(value + " popped from stack");
            return value;
        }
    }

    // Peek operation to view top element
    public int peep() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // Display all elements in stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Menu display
    public static void displayMenu() {
        System.out.println("\nStack Operations Menu");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peep");
        System.out.println("4. Display Stack");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter stack size: ");
        int size = sc.nextInt();
        StackWithArray stack = new StackWithArray(size);
        
        int choice, value;
        
        do {
            displayMenu();
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    value = stack.peep();
                    if (value != -1) {
                        System.out.println("Top element is: " + value);
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            if (choice != 5) {
                System.out.println("\nPress Enter to continue...");
                sc.nextLine(); // Consume newline
                sc.nextLine(); // Wait for Enter
            }
        } while (choice != 5);
        
        sc.close();
    }
}