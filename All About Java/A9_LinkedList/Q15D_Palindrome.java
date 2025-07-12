import java.util.*;
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class Q15D_Palindrome{
    Node head;
    Node tail;
    void insert(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    void display(){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    boolean palindrome(){
       if(head==null){
        System.out.println("Empty");
        return false;
       } 
       Node f=head;
       Node e=tail;
       while(f!=e){
        if(f.data!=e.data)return false;
        f=f.next;
        e=e.prev;
       }
       return true;
    }


    public static void main(String[] args){
        Q15D_Palindrome list= new Q15D_Palindrome();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(3);
        list.insert(2);
        list.insert(1);

        list.display();
        System.out.println("is Palindrome? "+list.palindrome());
    }
}