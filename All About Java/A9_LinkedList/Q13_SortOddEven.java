/*
input: [2,1,3,5,6,4,7]
output: [2,3,6,7,1,5,4]
The first node is considered odd, and the second node is even, and so on.
 */

import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

class Q13_SortOddEven{
    ListNode head;
    static ListNode SortOddEven(ListNode head){
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode tmpO = odd;
        ListNode tmpE = even;
        ListNode current = head;
        while(current!=null){
            /*if(current.val%2==0){
                tmpE.next=current;
                tmpE=tmpE.next;
            }else{
                tmpO.next=current;
                tmpO=tmpO.next;
            }
            current=current.next;*/
            tmpO.next=current;
            current=current.next;
            tmpO=tmpO.next;

            tmpE.next=current;
            if(current==null)break;
            current=current.next;
            tmpE=tmpE.next;
        }
        // Terminate the even list
        //tmpE.next = null;

        odd=odd.next;
        even=even.next;
        tmpO.next=even;
        
        return odd;
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
        Q13_SortOddEven list = new Q13_SortOddEven();
        
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(5);
        list.head.next.next.next.next.next = new ListNode(6);
        list.head.next.next.next.next.next.next = new ListNode(7);
        
        

        

        System.out.print("Old List: ");
        list.Display();
        list.head = list.SortOddEven(list.head);
        System.out.print("New Sorted Odd Even List: ");
        list.Display();
        
    
    }
}