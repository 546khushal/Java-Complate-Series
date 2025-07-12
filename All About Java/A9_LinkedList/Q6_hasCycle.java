import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

class Q6_hasCycle{
    public boolean hasCycle(ListNode head){
        //if(head==null || head.next==null)return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)return true;
        }
        return false;
    }
    public static void main(String[] args){
        Q6_hasCycle list = new Q6_hasCycle();

        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-1);

        head.next = second;
        second.next = third;
        third.next=fourth;
        fourth.next=second;//Create a cycle

        System.out.println("Does the linked list have a cycle? "+list.hasCycle(head));
    
        fourth.next=null;
        System.out.println("Does the linked list have a cycle? "+list.hasCycle(head));
    
    
    }
}