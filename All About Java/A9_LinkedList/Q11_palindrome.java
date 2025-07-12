import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

class Q11_palindrome{
    ListNode head;
    /*//Method 1: 
    //create duplicate and reverse duplicate and match each digit
    static boolean  palindrome(ListNode head,Q11_palindrome duplicate){
        ListNode current=head;
        // Create a copy of the original list in `duplicate`
        ListNode dhead=null,dtail=null;

        while(current!=null){
            ListNode newNode = new ListNode(current.val);
            if(dhead==null){
                dhead=newNode;
                dtail = dhead;
            }else{
                dtail.next=newNode;
                dtail=dtail.next;
            }
            current=current.next;
        }
        //Reverse the copied list
        dhead=reverse(dhead);
        current=head;

        while(current!=null && dhead!=null){
            if(current.val!=dhead.val){
                return false;
            }
            current=current.next;
            dhead=dhead.next;
        }
        return true;

    }
    */
   static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode next=null;
        ListNode current=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    


    //Method 2:find middle, reverse next part ,connect  with old,check p1,p2
    static boolean  palindrome(ListNode head){
        ListNode slow=head;
        ListNode fast = head;
        //find middle
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //reverse right half
        ListNode tmp= reverse(slow.next);
        slow.next = tmp;
        ListNode p1=head;
        ListNode p2=slow.next;
        while(p2!=null){
            if(p1.val!=p2.val)return false;
            p1=p1.next;
            p2=p2.next;
        }
        return true;
        
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
        Q11_palindrome list = new Q11_palindrome();
        Q11_palindrome duplicate = new Q11_palindrome();
      
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(3);
        list.head.next.next.next.next.next = new ListNode(2);
        list.head.next.next.next.next.next.next = new ListNode(1);
        

        System.out.print("Old List: ");
        list.Display();
        
        //System.out.println("Is Palindrome? "+palindrome(list.head, duplicate));// Updates list.head to the new head of the reversed list
        System.out.println("Is Palindrome? "+palindrome(list.head));

        
    }
}