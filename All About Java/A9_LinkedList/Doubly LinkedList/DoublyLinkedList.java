import java.util.Scanner;

class DoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    static Scanner sc = new Scanner(System.in);

    // Insert at beginning
    void insertAtBegin(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("\nData inserted successfully at the beginning!");
    }

    // Insert at end
    void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("\nData inserted successfully at the end!");
    }

    // Insert at position
    void insertAtPosition(int value, int pos) {
        if(pos < 1) {
            System.out.println("Invalid position! Position must be >= 1");
            return;
        }
        
        if(pos == 1) {
            insertAtBegin(value);
            return;
        }
        
        Node newNode = new Node(value);
        Node current = head;
        int count = 1;
        
        while(current != null && count < pos-1) {
            current = current.next;
            count++;
        }
        
        if(current == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        
        newNode.next = current.next;
        newNode.prev = current;
        if(current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
        System.out.println("Data inserted successfully at position " + pos);
    }

    // Insert in sorted order
    void insertSorted(int value) {
        Node newNode = new Node(value);
        if(head == null || head.data >= value) {
            insertAtBegin(value);
            return;
        }
        
        Node current = head;
        while(current.next != null && current.next.data < value) {
            current = current.next;
        }
        
        newNode.next = current.next;
        newNode.prev = current;
        if(current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
        System.out.println("\nSuccessfully inserted in sorted order!");
    }

    // Delete from beginning
    void deleteAtBegin() {
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        System.out.println("Deleted node with value: " + head.data);
        if(head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete from end
    void deleteAtEnd() {
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        System.out.println("Deleted node with value: " + tail.data);
        if(head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Delete at position
    void deleteAtPosition(int pos) {
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        if(pos < 1) {
            System.out.println("Invalid position!");
            return;
        }
        
        if(pos == 1) {
            deleteAtBegin();
            return;
        }
        
        Node current = head;
        int count = 1;
        
        while(current != null && count < pos) {
            current = current.next;
            count++;
        }
        
        if(current == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        
        System.out.println("Deleted node with value: " + current.data);
        current.prev.next = current.next;
        if(current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
    }

    // Delete by value
    void deleteValue(int value) {
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = head;
        while(current != null && current.data != value) {
            current = current.next;
        }
        
        if(current == null) {
            System.out.println("Value not found in list!");
            return;
        }
        
        System.out.println("Deleted node with value: " + current.data);
        if(current == head) {
            deleteAtBegin();
        } else if(current == tail) {
            deleteAtEnd();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    // Reverse the list
    void reverse() {
        if(head == null || head == tail) {
            return;
        }
        
        Node current = head;
        Node temp = null;
        
        while(current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        
        temp = head;
        head = tail;
        tail = temp;
        System.out.println("List reversed successfully!");
    }

    // Get size of list
    int getSize() {
        int count = 0;
        Node current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Swap two nodes (by value)
    void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    // Bubble sort
    void bubbleSort() {
        if(head == null || head == tail) {
            return;
        }
        
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            
            while(current.next != null) {
                if(current.data > current.next.data) {
                    swap(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while(swapped);
        
        System.out.println("List sorted successfully!");
    }

    // Display the list
    void display() {
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        System.out.print("List (Forward): ");
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
        
        System.out.print("List (Backward): ");
        current = tail;
        while(current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Search for a value
    int search(int value) {
        Node current = head;
        int index = 0;
        
        while(current != null) {
            if(current.data == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        
        return -1;
    }

    // Main menu
    static void mainMenu() {
        System.out.println("\n1. Add New Node");
        System.out.println("2. Insert Sorted Element");
        System.out.println("3. Delete Node");
        System.out.println("4. Search Element");
        System.out.println("5. Sort List");
        System.out.println("6. Reverse List");
        System.out.println("7. Display List");
        System.out.println("8. Exit");
        System.out.print("\nEnter Your Choice: ");
    }

    // Add menu
    void addMenu() {
        int choice, value;
        do {
            System.out.println("\n1. Add At Beginning");
            System.out.println("2. Add At End");
            System.out.println("3. Add At Position");
            System.out.println("4. Back to Main Menu");
            System.out.print("\nEnter Your Choice: ");
            choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    insertAtBegin(value);
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    insertAtEnd(value);
                    break;
                case 3:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    insertAtPosition(value, pos);
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            
            if(choice != 4) {
                display();
            }
        } while(choice != 4);
    }

    // Delete menu
    void deleteMenu() {
        int choice, value, pos;
        do {
            System.out.println("\n1. Delete From Beginning");
            System.out.println("2. Delete From End");
            System.out.println("3. Delete At Position");
            System.out.println("4. Delete By Value");
            System.out.println("5. Back to Main Menu");
            System.out.print("\nEnter Your Choice: ");
            choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    deleteAtBegin();
                    break;
                case 2:
                    deleteAtEnd();
                    break;
                case 3:
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    deleteAtPosition(pos);
                    break;
                case 4:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    deleteValue(value);
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            
            if(choice != 5) {
                display();
            }
        } while(choice != 5);
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        int choice, value;
        
        do {
            mainMenu();
            choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    list.addMenu();
                    break;
                case 2:
                    System.out.print("Enter value to insert in sorted order: ");
                    value = sc.nextInt();
                    list.insertSorted(value);
                    list.display();
                    break;
                case 3:
                    list.deleteMenu();
                    break;
                case 4:
                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();
                    int pos = list.search(value);
                    if(pos != -1) {
                        System.out.println("Value found at position: " + pos);
                    } else {
                        System.out.println("Value not found in list!");
                    }
                    break;
                case 5:
                    list.bubbleSort();
                    list.display();
                    break;
                case 6:
                    list.reverse();
                    list.display();
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            
            if(choice != 8) {
                System.out.println("\nPress Enter to continue...");
                sc.nextLine();
                sc.nextLine();
            }
        } while(choice != 8);
    }
}