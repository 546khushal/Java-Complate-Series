import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

class Q10_revLinkList{
    ListNode head;
    void reverseList(ListNode head){
        ListNode prev=null;
        ListNode next=null;
        ListNode current=head;
        while(current!=null){
            next=current.next; // Store next node
            current.next=prev;// Reverse the link
            prev=current;// Move prev one step forward
            current = next;       // Move current one step forward
        }
        this.head=prev;
    }

    static ListNode reverseUsingRecursion(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode newHead = reverseUsingRecursion(head.next);
        head.next.next = head;//interchanging 
        head.next=null;// Set the current node's next to null
        return newHead;
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

    static void displayRev(ListNode head){
        if(head==null)return;
        displayRev(head.next);
        System.out.print(head.val+" ");
    }

    public static void main(String[] args){
        Q10_revLinkList list = new Q10_revLinkList();

        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(2);
        list.head.next.next.next = new ListNode(3);
        list.head.next.next.next.next = new ListNode(4);
        list.head.next.next.next.next.next = new ListNode(5);
        list.head.next.next.next.next.next.next = new ListNode(5);
        

        System.out.print("Old List: ");
        list.Display();
        
        //list.reverseList(list.head);
        list.head=reverseUsingRecursion(list.head);// Updates list.head to the new head of the reversed list
        System.out.print("New Reverse List: ");
        list.Display();

        //System.out.print("Display Reverse List: ");
        //displayRev(list.head);//not change node only display reverse
    
    }
}