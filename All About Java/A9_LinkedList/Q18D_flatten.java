/*
Problem: Flatten a Multilevel Doubly Linked List

You are given a doubly linked list where nodes may have an additional child pointer that points to another doubly linked list.
Flatten the list so all nodes appear in a single-level, maintaining the order where child lists come after their parent and before the parent's next node.

Example 1:
Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Visualization:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
Output: [1,2,3,7,8,11,12,9,10,4,5,6]

Example 2:
Input: head = [1,2,null,3]
Output: [1,3,2]

Example 3:
Input: head = []
Output: []
*/
import java.util.Arrays;

class Node {
    int val;
    Node prev;
    Node next;
    Node child;

    Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
        this.child = null;
    }
}

class Q18D_flatten {
    Node head;

    void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    Node buildList(Integer[] values) {
        if (values == null || values.length == 0) return null;

        Node dummy = new Node(0); // Dummy node to simplify list creation
        Node current = dummy;
        int i = 0;

        while (i < values.length) {
            if (values[i] == null) {
                // Handle child list creation
                i++; // Skip the first null
                int start = i;
                while (i < values.length && values[i] != null) i++; // Find the end of child list
                if (start < values.length) {
                    current.child = buildList(Arrays.copyOfRange(values, start, i));
                }
            } else {
                // Create a new node
                Node newNode = new Node(values[i]);
                current.next = newNode;
                newNode.prev = current;
                current = newNode;
            }
            i++;
        }

        return dummy.next; // Return the actual head
    }

    /*Node flatten(Node head) {
        if (head == null) return null;

        Node current = head;
        while (current != null) {
            if (current.child != null) {
                // Flatten the child list
                Node child = current.child;
                Node next = current.next;

                // Find the tail of the child list
                Node childTail = child;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                // Connect current to child
                current.next = child;
                child.prev = current;

                // Connect child tail to next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                // Clear the child pointer
                current.child = null;
            }
            current = current.next; // Move to the next node
        }

        return head;
    }*/

    public Node flatten(Node head) {
        Node temp=head;
        while(temp!=null){
            Node t= temp.next;
            if(temp.child!=null){
               Node c = flatten(temp.child);
               temp.next=c;
               c.prev=temp;
               while(c.next!=null){
                    c=c.next;
                } 
                c.next=t;
                if(t!=null)t.prev=c;
            }
            temp.child=null;//sabhi child ko null bna diya
            temp=t;//t phle hi t=temp.next hai;
        }
        return head;
    }

    public static void main(String[] args) {
        Q18D_flatten list = new Q18D_flatten();

        Integer[] input1 = {1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10, null, null, 11, 12};
        list.head = list.buildList(input1);

        System.out.println("Original List:");
        list.display(list.head);

        System.out.println("\nFlattened List:");
        Node flattenedHead = list.flatten(list.head);
        list.display(flattenedHead);
    }
}
