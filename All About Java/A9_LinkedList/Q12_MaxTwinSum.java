/*
Maximum  twin sum of a linked list
In a linked list of size n, where n is even, the ith ListNode (0-indexed) of the linked list is known as the twin of the (n-1-i)th ListNode, if 0 <= i <= (n / 2) - 1.
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}


class Q12_MaxTwinSum{
    ListNode head;
    int MaxTwinSum(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next.next;
        }
        ListNode tmp=reverse(slow.next);
        slow.next=tmp;
        ListNode p1=head;
        ListNode p2=slow.next;
        int max = Integer.MIN_VALUE;
        while(p2!=null){
            int sum=p1.val+p2.val;
            if(sum>max){
                max=sum;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return max;

    }
    ListNode reverse(ListNode head){
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
        Q12_MaxTwinSum list = new Q12_MaxTwinSum();

        list.head=new ListNode(5);
        list.head.next=new ListNode(4);
        list.head.next.next=new ListNode(2);
        list.head.next.next.next=new ListNode(1);
        //list.head.next.next.next.next=new ListNode(4);
        //list.head.next.next.next.next.next=new ListNode(1);
        //list.head.next.next.next.next.next.next=new ListNode(1);
        //list.head.next.next.next.next.next.next.next=new ListNode(1);
        //list.head.next.next.next.next.next.next.next.next=new ListNode(1);

        System.out.print("Old List: ");
        list.Display();

        System.out.print(list.MaxTwinSum(list.head));

    }
}
