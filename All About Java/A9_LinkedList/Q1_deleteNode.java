import java.util.*;
class Q1_deleteNode{
    static Scanner sc = new Scanner(System.in);
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head;
    void Append(int value){
        Node newNode= new Node(value);
        if(head==null || head.data>value){
            newNode.next=head;
            head=newNode;
        }else{
            Node current = head;
            while(current.next!=null && head.next.data<=value){
                current=current.next;
            }
            newNode.next = current.next;
            current.next=newNode;
        }
        System.out.println("Append Succesfully");
    }
    void display(){
        Node current = head;
        if(head==null){
            System.out.println("List Empty");
        }
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }
    void deleteValue(int value){
        Node toDelete=head,old=null;
        if(head==null){
            System.out.println("Empty");
        }
        while(toDelete!=null){
            if(toDelete.data==value){
                if(toDelete==head){
                    head=head.next;
                    System.out.println("deleted element"+toDelete.data);
                    return;
                }else{
                    System.out.println("deleted element"+toDelete.data);
                    old.next=toDelete.next;
                    return;
                }
            }
            old=toDelete;
            toDelete=toDelete.next;
        }
    }

    public static void main(String[] args){
        Q1_deleteNode list = new Q1_deleteNode();
        
        int value;
        int i=0;
        while(i!=5){
            System.out.print("Enter value:");
            value = sc.nextInt();
            list.Append(value);
            i++;
        }
        i=0; 
        list.display();
        while(i!=3){
        System.out.print("\nEnter delete value: ");
        value = sc.nextInt();
        list.deleteValue(value);
        list.display();
        i++;}
    }

}
