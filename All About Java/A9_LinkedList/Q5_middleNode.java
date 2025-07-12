import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Use two-pointer technique
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    public ListNode deleteMiddle(ListNode head) {
         if(head.next==null)return null;
        Node slow = head;
        ListNode fast = head;
        while(fast.next.next!=null && fast.next.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    /*
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int count=0;
        while(current!=null){
            current=current.next;
            count++;
        }
        current=head;
        int  mid=count/2,i=0;
        while(i < mid){
            current=current.next;
            i++;
        }
        return current;
    }
     */
}

public class Q5_middleNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input: Create a linked list
        System.out.println("Enter the number of nodes in the linked list:");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("The linked list is empty.");
            return;
        }
        
        System.out.println("Enter the values for the linked list:");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;
        
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }
        
        // Find the middle node
        Solution solution = new Solution();
        ListNode middle = solution.middleNode(head);
        
        // Output the value of the middle node
        System.out.println("The middle node value is: " + middle.val);
    }
}
