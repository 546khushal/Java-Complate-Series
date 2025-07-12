import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

class Q8_SplitOddEven{
    ListNode head;
    static void SplitOddEven(ListNode head,Q8_SplitOddEven odd,Q8_SplitOddEven even){
        ListNode oTail =null;
        ListNode eTail =null;
        ListNode current=head;
        while(current!=null){
            ListNode newNode=new ListNode(current.val);
            if(current.val%2==0){
                if(even.head == null){
                    even.head= newNode;
                    eTail=even.head;
                }else{
                    eTail.next = newNode;
                    eTail=eTail.next;
                }
            }else{
                if(odd.head == null){
                    odd.head=newNode;
                    oTail=odd.head;
                }else{
                    oTail.next = newNode;
                    oTail=oTail.next;
                }
            }
            
            current=current.next;
        }
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
        Q8_SplitOddEven list = new Q8_SplitOddEven();
        Q8_SplitOddEven odd = new Q8_SplitOddEven();
        Q8_SplitOddEven even = new Q8_SplitOddEven();

        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(5);
        list.head.next.next.next.next.next = new ListNode(6);
        list.head.next.next.next.next.next.next = new ListNode(7);
        
        SplitOddEven(list.head,odd,even);

        

        System.out.print("Odd List: ");
        odd.Display();
        System.out.print("Even List: ");
        even.Display();
        
    
    }
}