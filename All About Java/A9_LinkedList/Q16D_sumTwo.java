//sum two node is target in sorted list 
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
class Q16D_sumTwo{
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

    void sumTwo(int target){
       if(head==null){
        System.out.println("Empty");
        return ;
       } 
       Node f=head;
       Node e=tail;
       while(f.data<e.data){
            int sum = f.data+e.data;
            if(sum==target){
                System.out.println("first node is :"+f.data+"\nSecond node is: "+e.data);
                return;
            }else if(sum>target){
                e=e.prev;
            }else{
                f=f.next;
            }
       }
       return;
    }


    public static void main(String[] args){
        Q16D_sumTwo list= new Q16D_sumTwo();
        list.insert(3);
        list.insert(5);
        list.insert(8);
        list.insert(13);
        list.insert(100);

        list.display();
        list.sumTwo(113);
    }
}