import java.util.Scanner;

class SinglyLinkedList{
    Node head;
    static Scanner sc = new Scanner(System.in);
    //under banane se encpsulation hua private bhi use kr skte
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    
    //insertAtBegin is an instance method (non-static) because it accesses the instance variable head. You cannot make it static unless you pass the head as a parameter.
    void insertAtBegin(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        System.out.println("\nData inserted Successfully At the Begining!");
    }
    void insertAtEnd(int value){
        Node newNode = new Node(value);
        Node current=head;
        if(newNode==null){
            System.out.println("Memory Allocation Fail!");
            return;
        }
        if(head==null){
            head=newNode;   
        }else{
            while(current.next != null){
                current = current.next;
            }
            current.next=newNode;
        }
        System.out.println("\nData inserted Successfully At the Ending!");
    }

    void insertAtPosition(int value,int pos){
        Node newNode = new Node(value);
        if(pos<1){
            System.out.println("Invalid Position! position must be >1");
            return;
        }
        if(pos==1){
            insertAtBegin(value);
            return;
        }
        Node current=head;
        for(int i=1;i<pos-1;i++){
            if(current.next==null){
                System.out.println("Invalid Position! Position out of Bound");    
                return;
            }
            current = current.next;
        }
        newNode.next=current.next;
        current.next=newNode;
        System.out.println("Data Inserted Successfully at the Positon "+pos);
    }

    void insertSorted(int value){
        Node newNode = new Node(value);
        Node current=head;
        if(head==null || head.data>value){
            newNode.next = head;
            head = newNode;
        }else{
                while(current.next != null && current.next.data <= value) {
                    current = current.next;
                }            
                // Node ko insert karo
                newNode.next = current.next;
                current.next = newNode;
        }
        
        System.out.println("\nSuccessfully inserted in sorted order!");
    }

    void deleteAtBegin(){
        if(head==null){
            System.out.println("Linked List is empty now!");
            return;
        }
        Node toDelete = head;
        head=head.next;
        System.out.println("Node deleted with "+toDelete.data);
        // Java automatically garbage collect karega, hume manually free karne ki jarurat nahi
    }
    void deleteAtEnd(){
        if(head==null){
            System.out.println("Linked List is Emoty now!");
            return;
        }
        if(head.next==null){
            System.out.println("Deleted node with value:"+head.data);
            return;
        }

        Node current=head;
        while(current.next.next!=null){
            current=current.next;
        }
        System.out.println("\nDeleted node with value: " + current.next.data);
        current.next=null;
    }
    void deleteAtPosition(int pos){
        Node current,toDelete;
        if(head==null){
            System.out.println("Linked list empty Empty now!");
            return;
        }
        if(pos<1){
            System.out.println("Invalid Position!");
            return;
        }
        if(pos==1){
            deleteAtBegin();
            return;
        }
        current = head;
        for(int i=1;i<pos-1 && current!=null ;i++){
            current=current.next;
        }
        if(current == null || current.next==null){
            System.out.println("Position Out of Bound");
            return;
        }
        toDelete = current.next;
        current.next=toDelete.next;
        System.out.println("Deleted Node with value "+toDelete.data);
    }
    void deleteValue(int value){
        Node toDelete,old=null;
        toDelete=head;
        while(toDelete!=null){
            if(toDelete.data == value){
                if(toDelete==head){
                    head=head.next;
                    System.out.println("Deleted Node with value"+toDelete.data);
                    return;
                }else{
                    System.out.println("Deleted Node with value"+toDelete.data);
                    old.next=toDelete.next;
                    return;
                }
            }else{
                old=toDelete;
                toDelete=toDelete.next;
            }
        }
        System.out.printf("Entered value %d is not present",value);
    }
    void reverse(){
        Node prev=null,next=null;
        Node current=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }

    int getSize(){
        int size=0;
        Node current=head;
        while(current!=null){
            size++;
            current=current.next;
        }
        return size;
    }
    void swap(Node a,Node b){
        int tmp=a.data;
        a.data=b.data;
        b.data=tmp;
    }
    void bubbleSort(){
        int size=getSize();
        Node current=null;
        if(head==null || size<2){
            return;
        }
        for(int i=0;i<size-1;i++){
            current=head;
            for(int j=0;j<size-i-1;j++){
                if(current.data>current.next.data){
                    swap(current,current.next);
                }
                current=current.next;
            }
        }
    }
    
    void display(){
        Node current = head;
        if(current==null){
            System.out.println("Linked list is empty.");
            return;
        }
        System.out.println("Linked list Element: ");
        System.out.print("Head -> ");
        while(current != null){
            //System.out.print("[ "+current.data+" | "+current.next+" ] -> ");
            System.out.print(current.data+" -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    /*
    void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        System.out.println("Linked list elements:");
        display(head); // Start recursion from the head
        System.out.println("null"); // Indicate the end of the list
    }

    private void display(Node current) {
        if (current == null) {
            return; // Base case: End of the list
        }
        System.out.print(current.data + " -> "); // Print the current node
        display(current.next); // Recursive call for the next node
    }

    */

    int search(int value){
        Node current=head;
        int index=0;
        while(current!=null){
            if(current.data==value){
                return index; 
            }
            index++;
            current=current.next;
        }
        return -1;
    }

    //static because they don't access instance variables directly
    static void mainMenu(){
        System.out.println("\n1. Add New Node");
        System.out.println("2. Insert Sorted Element");
        System.out.println("3. Delete Node");
        System.out.println("4. Search Element");
        System.out.println("5. Sorting Linked list");
        System.out.println("6. Reverse List");
        System.out.println("7. Display");
        System.out.println("8. Exit");
        System.out.print("\nEnter Your Choice: ");
    }
    // Static method because it doesn't access instance variables directly (but needs 'list' as parameter)
    //static void addMenu(SinglyLinkedList list) 
    void addMenu(){
        int choice,value;
        do{
            System.out.println("\n1. Add At Begin");
            System.out.println("2. Add At Ending");
            System.out.println("3. Add At Position");
            System.out.println("4. Exit");
            System.out.print("\nEnter Your Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter value: ");
                    value = sc.nextInt();
                    //list.insertAtBegin(value);
                    //this.insertAtBegin(value);
                    insertAtBegin(value);
                    break;
                case 2:
                    System.out.print("\nEnter value: ");
                    value = sc.nextInt();
                    insertAtEnd(value);
                    break; 
                case 3:
                    System.out.print("\nEnter value: ");
                    value = sc.nextInt();
                    System.out.print("\nEnter position: ");
                    int pos = sc.nextInt();
                    insertAtPosition(value,pos);
                    break;
                case 4:
                    System.out.println("\nReturning to main menu...");
                    break;
                default:
                    System.out.println("Invalid Choice Boss! Please enter right Choice");
            }
            if (choice != 4) {
                System.out.println("\nPress Enter to continue...");
                sc.nextLine(); // Consume newline
                sc.nextLine(); // Wait for Enter
            }
        } while (choice != 4);
    
    }
    void deleteMenu(){
        int choice,value,pos;
        do{
            System.out.println("1. Delete At Begin");
            System.out.println("2. Delete At Ending");
            System.out.println("3. Delete At Position");
            System.out.println("4. Delete At Value");
            System.out.println("5. Exit");
            System.out.println("Enter Your Choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    deleteAtBegin();
                    display();
                    break;
                case 2:
                    deleteAtEnd();
                    display();
                    break;
                case 3:
                    System.out.print("Enter position: ");
                    pos=sc.nextInt();
                    deleteAtPosition(pos);
                    display();
                    break;
                case 4:
                    System.out.print("Enter value: ");
                    value=sc.nextInt();
                    deleteValue(value);
                    display();
                    break;
                case 5:
                    System.out.println("\nReturning to main menu...");
                    break;
                default:
                    System.out.println("Invalid Choice Boss! Please enter right Choice");
            }
            if(choice!=5){
                System.out.println("\nPress Enter to continue...");
                sc.nextLine(); // Consume newline
                sc.nextLine(); // Wait for Enter
            }
        }while(choice!=5);
    }
    
    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        int choice,value;
        do{
            mainMenu();
            choice =sc.nextInt();
            switch(choice){
                case 1:
                    list.addMenu();
                    break;
                case 2:
                    System.out.print("Enter Element: ");
                    value = sc.nextInt();
                    list.insertSorted(value);
                    break;
                case 3:
                    list.deleteMenu();
                    break;
                case 4:
                    System.out.print("Enter Element to be search: ");
                    value = sc.nextInt();
                    int pos = list.search(value);
                    if(pos!=-1){
                        System.out.println("Element found at position " + pos);
                    }else{
                        System.out.println("Element not found");
                    }
                    break;
                case 5:
                    list.bubbleSort();
                    list.display();
                    break;
                case 6:
                    list.reverse();
                    break;
                case 7:
                    list.display();//// Call instance method on 'list'
                    break;
                 case 8:
                    System.out.println("\nReturning to main menu...");
                    break;
                default:
                    System.out.println("Invalid Choice Boss! Please enter right Choice");
            }
            if (choice != 8) {
                System.out.println("\nPress Enter to continue...");
                sc.nextLine(); // Consume newline
                sc.nextLine(); // Wait for Enter
            }
        } while (choice != 8);
    }
/*yadi head ko bhi parameters se pass krna to function static bna kr use kre 
 Node head = null; in main
  head = insertAtBegin(head, value);
  head = deleteAtBegin(head);
  head = deleteAtEnd(head);
  display(head);
*/
// 1. list.insertAtBegin() - Use tab karein jab:
//    - Alag object pe call karna ho (jaise main method mein)
//    - Code ko bahar se padhne wale ko clear pata chale kis object pe call ho raha hai

// 2. this.insertAtBegin() - Use tab karein jab:
//    - Local variable ka naam same ho (name conflict ho)
//    - Current object pe call karna ho aur explicitly batana ho
//    - Example: this.insertAtBegin() vs parameter variable

// 3. Direct insertAtBegin() - Use tab karein jab:
//    - Simple and clean code chahiye ho
//    - Current class ke method se hi call kar rahe ho
//    - Most common and preferred way
}