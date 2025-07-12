class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Q4_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head; // If the list has 0 or 1 node, no swaps are needed
        }

        // Dummy node to simplify the swap process
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            // Nodes to be swapped
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move to the next pair
            prev = first;
        }

        return dummy.next; // Return the updated list
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
        Q4_SwapNodesInPairs solution = new Q4_SwapNodesInPairs();

        // Input for the list
        int[] values = {1, 2, 3, 4};
        System.out.println("Original List:");
        ListNode list = createList(values);
        printList(list);

        // Perform node swapping
        System.out.println("Swapped List:");
        ListNode swappedList = solution.swapPairs(list);
        printList(swappedList);
    }
}
/**For the list [1, 2, 3, 4]:

    Initial pointers:

        prev -> dummy (-1)

        first -> 1

        second -> 2

    First Swap:

        first.next = second.next → 1.next = 3

        second.next = first → 2.next = 1

        prev.next = second → dummy.next = 2

    Updated list: -1 -> 2 -> 1 -> 3 -> 4

    Move to next pair:

        prev = first → prev = 1

    Second Swap:

        first -> 3, second -> 4

        Perform similar pointer updates.

    Final list: -1 -> 2 -> 1 -> 4 -> 3

Return dummy.next, i.e., 2 -> 1 -> 4 -> 3. */