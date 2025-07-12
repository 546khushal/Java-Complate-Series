/*
Depth-First Search is a graph traversal algorithm that:
    Starts from a node and explores as deep as possible along each branch before backtracking.
    Uses a stack (implicitly via recursion or explicitly with a Stack data structure). */
import java.util.*;

class Node {
    int value;
    List<Node> neighbors = new ArrayList<>();

    Node(int value) {
        this.value = value;
    }
}

public class DFSWithStack {
    
    // DFS using explicit Stack (Iterative)
    static void dfsIterative(Node start) {
        Stack<Node> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (!visited.contains(current.value)) {
                System.out.print(current.value + " ");
                visited.add(current.value);

                // Push neighbors in reverse to maintain DFS order
                for (int i = current.neighbors.size() - 1; i >= 0; i--) {
                    Node neighbor = current.neighbors.get(i);
                    if (!visited.contains(neighbor.value)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Creating graph nodes
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        // Creating undirected edges
        a.neighbors.add(b);
        a.neighbors.add(c);
        b.neighbors.add(a);
        b.neighbors.add(d);
        c.neighbors.add(a);
        d.neighbors.add(b);

        // Call DFS
        System.out.println("DFS traversal using stack:");
        dfsIterative(a);  // Start from node 1
    }
}
