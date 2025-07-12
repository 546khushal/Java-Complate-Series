/*The LinkedList class in Java (part of the java.util package) implements both the List and Deque interfaces. This makes it versatile, supporting methods for both sequential access (like an ArrayList) and queue operations (like a Deque or Queue).

1. Adding Element:- l.add(10),add(int index,E element),addFirst(E element),addLast(E element)
2. Remove: remove(),remove(int index),remove("apple"),removeFirst(),removeLast(),
3. Accessing: get(int index),getFirst(),getLast(),
4. Modifying: set(int index, E elements)
5. Searching: contains(Object o),indexOf(object o),lastIndexOf(Object o)
 */

import java.util.*;

public class IntegerLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- LinkedList Operations ---");
            System.out.println("1. Insert First");
            System.out.println("2. Insert Last");
            System.out.println("3. Insert at Position");
            System.out.println("4. Remove First");
            System.out.println("5. Remove Last");
            System.out.println("6. Remove at Position");
            System.out.println("7. Remove by Value");
            System.out.println("8. Search");
            System.out.println("9. Sort");
            System.out.println("10. Display");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at first: ");
                    int valueFirst = sc.nextInt();
                    list.addFirst(valueFirst);
                    System.out.println("Inserted at first: " + valueFirst);
                    break;

                case 2:
                    System.out.print("Enter value to insert at last: ");
                    int valueLast = sc.nextInt();
                    list.addLast(valueLast);
                    System.out.println("Inserted at last: " + valueLast);
                    break;

                case 3:
                    System.out.print("Enter position (0-based index): ");
                    int position = sc.nextInt();
                    System.out.print("Enter value to insert: ");
                    int valueAtPosition = sc.nextInt();
                    if (position >= 0 && position <= list.size()) {
                        list.add(position, valueAtPosition);
                        System.out.println("Inserted " + valueAtPosition + " at position " + position);
                    } else {
                        System.out.println("Invalid position!");
                    }
                    break;

                case 4:
                    if (!list.isEmpty()) {
                        int removedFirst = list.removeFirst();
                        System.out.println("Removed first: " + removedFirst);
                    } else {
                        System.out.println("List is empty!");
                    }
                    break;

                case 5:
                    if (!list.isEmpty()) {
                        int removedLast = list.removeLast();
                        System.out.println("Removed last: " + removedLast);
                    } else {
                        System.out.println("List is empty!");
                    }
                    break;

                case 6:
                    System.out.print("Enter position (0-based index): ");
                    int removePosition = sc.nextInt();
                    if (removePosition >= 0 && removePosition < list.size()) {
                        int removedAtPosition = list.remove(removePosition);
                        System.out.println("Removed value at position " + removePosition + ": " + removedAtPosition);
                    } else {
                        System.out.println("Invalid position!");
                    }
                    break;

                case 7:
                    System.out.print("Enter value to remove: ");
                    int valueToRemove = sc.nextInt();
                    if (list.remove((Integer) valueToRemove)) {
                        System.out.println("Removed value: " + valueToRemove);
                    } else {
                        System.out.println("Value not found!");
                    }
                    break;

                case 8:
                    System.out.print("Enter value to search: ");
                    int valueToSearch = sc.nextInt();
                    if (list.contains(valueToSearch)) {
                        System.out.println("Value found at position: " + list.indexOf(valueToSearch));
                    } else {
                        System.out.println("Value not found!");
                    }
                    break;

                case 9:
                    Collections.sort(list);
                    System.out.println("List sorted!");
                    break;

                case 10:
                    if (!list.isEmpty()) {
                        System.out.println("LinkedList: " + list);
                    } else {
                        System.out.println("List is empty!");
                    }
                    break;

                case 11:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 11);

        sc.close();
    }
}
