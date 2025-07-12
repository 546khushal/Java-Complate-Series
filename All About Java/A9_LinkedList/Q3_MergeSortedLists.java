class ListNode {
    int val;
    ListNode next;

    // Constructors
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Q3_MergeSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }
   


   

    // Utility to create a linked list from an array
    public static ListNode createList(int[] values) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return head.next; // Skip dummy node
    }

    // Utility to print a linked list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Q3_MergeSortedLists solution = new Q3_MergeSortedLists();

        // Input for the first list
        int[] list1Values = {1, 2, 4};
        System.out.println("List 1:");
        ListNode list1 = createList(list1Values);
        printList(list1);

        // Input for the second list
        int[] list2Values = {1, 3, 4};
        System.out.println("List 2:");
        ListNode list2 = createList(list2Values);
        printList(list2);

        // Merge the two lists
        System.out.println("Merged List:");
        ListNode mergedList = solution.mergeTwoLists(list1, list2);
        printList(mergedList);
    }
}
