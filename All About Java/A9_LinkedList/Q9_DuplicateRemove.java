
import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
//remove duplicate from shorted linked list
class Q9_DuplicateRemove{
    ListNode head;
    void removeDuplicate(ListNode head){
        ListNode tmp=head;
        while(tmp!=null && tmp.next!=null){
            if(tmp.next.val==tmp.val){
                tmp.next=tmp.next.next;
            }
            else{
                tmp=tmp.next;
            }
        }
    }
    void removeDuplicate_withValue(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next=head;//connect dummy to actual list
        ListNode prev=dummy;
        ListNode tmp=head;
        while(tmp!=null){
            if(tmp.next!=null  && tmp.next.val==tmp.val){
                int dupli=tmp.val;
                while(tmp!=null && tmp.val==dupli){
                    tmp = tmp.next;
                }
                prev.next = tmp;
            }else{
                prev = tmp;
                tmp=tmp.next;
            }
        }
        this.head=dummy.next;
    }
    void Display(){
        ListNode curr=head;
        if(head==null){
            System.out.println("Empty");
            return;
        }
        while(curr!=null){
            System.out.print(curr.val+" ");
            curr=curr.next;
        }
         System.out.println();
    }
    public static void main(String[] args){
        Q9_DuplicateRemove list = new Q9_DuplicateRemove();

        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(2);
        list.head.next.next.next = new ListNode(3);
        list.head.next.next.next.next = new ListNode(4);
        list.head.next.next.next.next.next = new ListNode(5);
        list.head.next.next.next.next.next.next = new ListNode(5);
        

        System.out.print("Old List: ");
        list.Display();
        //list.removeDuplicate(list.head);
        //System.out.print("New List removed Duplicate: ");
        //list.Display();
        list.removeDuplicate_withValue(list.head);
        System.out.print("New  List with Removed Duplicate: ");
        list.Display();
    
    }
}