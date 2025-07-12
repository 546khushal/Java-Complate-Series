//delete nth nofr from end 
    


import java.util.*;
class Q2_deleteNthNodeFromEnd{
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
    /* //delete nth node from end but use double round 
    void deleteNthNode(int n){
        Node dummy = new Node(0);
        dummy.next=head;
        int count=0;
        Node current=head;
        while(current!=null){
            current=current.next;
            count++;
        }
        int m= count-n;
        current=dummy;//start from dummy with 0
        for(int i=0;i<m;i++){
            current=current.next;
        }
        current.next=current.next.next;
        head = dummy.next;
        
    }
    */
    //best way to delete nth node from end
    void deleteNthNode(int n){
        Node slow = head;
        Node fast = head;
        for(int i=1;i<=n;i++){
            fast=fast.next;
        }
        if(fast==null){
            head=head.next;
            return;
        }
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next;
        }
        if(slow!=null && slow.next!=null){
            slow.next=slow.next.next;
        }
    }
    public static void main(String[] args){
       Q2_deleteNthNodeFromEnd list = new Q2_deleteNthNodeFromEnd();
        
        int value;
        int i=0;
        while(i!=5){
            System.out.print("Enter value:");
            value = sc.nextInt();
            list.Append(value);
            i++;
        }
        
        list.display();
        i=0;
        while(i!=4){
        System.out.print("\nEnter nth to delete from n: ");
        value = sc.nextInt();
        list.deleteNthNode(value);
        list.display();
        i++;}
    }

}
