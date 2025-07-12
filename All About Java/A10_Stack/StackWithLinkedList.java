import java.util.Scanner;

class StackWithLinkedList {
    // Node class
    private class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node top; // top of stack
    private int size; // current size of stack
    
    // Constructor
    // public StackWithLinkedList() {
    //     this.top = null;
    //     this.size = 0;
    // }
    
    // Push operation
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println(value + " pushed to stack");
    }
    
    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }
        int value = top.data;
        top = top.next;
        size--;
        System.out.println(value + " popped from stack");
        return value;
    }
    
    // Peek operation
    public int peep() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
    
    // Display stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack elements (top to bottom):");
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    
    // Get stack size
    public int size() {
        return size;
    }
    
    // Menu display
    public static void displayMenu() {
        System.out.println("\nStack Operations Menu");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peep");
        System.out.println("4. Display Stack");
        System.out.println("5. Stack Size");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackWithLinkedList stack = new StackWithLinkedList();
        
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
                    System.out.println("Current stack size: " + stack.size());
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            if (choice != 6) {
                System.out.println("\nPress Enter to continue...");
                sc.nextLine(); // Consume newline
                sc.nextLine(); // Wait for Enter
            }
        } while (choice != 6);
        
        sc.close();
    }
}