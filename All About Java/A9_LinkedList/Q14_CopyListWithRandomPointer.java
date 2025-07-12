/*A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
class Node{
    int val;
    Node next;
    Node random;
    Node(int val){
        this.val=val;
        this.next=null;
        this.random=null;
    }
}
class Q14_CopyListWithRandomPointer{
    public Node copyRandomList(Node head){
        //7 13 11 10 1
        //n  7  1 11 7
        //0 deepcopy
        Node head2=new Node(0);
        Node tmp2 = head2;
        Node tmp1=head;//origanal ka point
        //creating deep copy 7 13 11 10 1
        while(tmp1!=null){
            Node t = new Node(tmp1.val);
            tmp2.next=t;
            tmp2=t;
            tmp1=tmp1 .next;
        }
        head2=head2.next;// Skip the dummy node
        tmp2=head2;// Reset pointer for new list
        tmp1=head;// Reset pointer for original list
        //alternate connection
        Node tmp=new Node(0);
        while(tmp1!=null){
            // Pehle original node ko jodo
            tmp.next=tmp1;
            tmp1=tmp1.next;
            tmp=tmp.next;
            // Phir copy node ko jodo
            tmp.next=tmp2;
            tmp2=tmp2.next;
            tmp=tmp.next;
        }
        tmp2=head2;
        tmp1=head;
        /*Original: 7 -> 13 -> 11 -> 10 -> 1
            Copy: 7 -> 13 -> 11 -> 10 -> 1

            After weaving:
            7 (original) -> 7 (copy) -> 13 (original) -> 13 (copy) -> 11 (original) -> 11 (copy) -> 10 (original) -> 10 (copy) -> 1 (original) -> 1 (copy) */
        //assigning random pointer
        while(tmp1!=null ){
            if(tmp1.random==null)
                tmp2.random=null;
            else
                tmp2.random=tmp1.random.next;// Original ke random ka copy

            tmp1=tmp2.next;// Original list ka agla node
            if(tmp1!=null)tmp2=tmp1.next;// Copy list ka agla node
        }
        tmp2=head2;
        tmp1=head;
        //Separating the list
        while(tmp1!=null){
            tmp1.next=tmp2.next;
            tmp1=tmp1.next;
            if(tmp1==null)break;
            tmp2.next=tmp1.next;
            if(tmp2.next==null)break;
            tmp2=tmp2.next;
        }
        return head2;
    }

    public static void displayList(Node head) {
        Node current = head;
        while (current != null) {
            int randomVal = (current.random != null) ? current.random.val : -1;
            System.out.println("Node: " + current.val + ", Random: " + randomVal);
            current = current.next;
        }
    }
    
    public static void main(String[] args){
        Q14_CopyListWithRandomPointer list = new Q14_CopyListWithRandomPointer();

        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        // Assign random pointers
        head.random = null; // 7 -> null
        head.next.random = head; // 13 -> 7
        head.next.next.random = head.next.next.next.next; // 11 -> 1
        head.next.next.next.random = head.next.next; // 10 -> 11
        head.next.next.next.next.random = head; // 1 -> 7

        System.out.println("Original List:");
        displayList(head);

        Node copiedHead = list.copyRandomList(head);
        System.out.println("\nCopied List:");
        displayList(copiedHead);
    }
}