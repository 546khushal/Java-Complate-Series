import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

class Q7_FindNodehasCycle{
    public ListNode NodehasCycle(ListNode head){
        //if(head==null || head.next==null)return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                ListNode tmp= head;
                while(tmp!=slow){
                    tmp=tmp.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args){
        Q7_FindNodehasCycle list = new Q7_FindNodehasCycle();

        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-1);

        head.next = second;
        second.next = third;
        third.next=fourth;
        fourth.next=second;//Create a cycle
 
        ListNode res= list.NodehasCycle(head);
        System.out.println("this node where the cycle begins:  "+res.val);
    
        fourth.next=null;
        res= list.NodehasCycle(head);
        System.out.println("this node where the cycle begins:  "+res);
    
    
    }
}