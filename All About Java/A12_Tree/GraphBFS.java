/**BFS stands for Breadth-First Search, an algorithm to traverse or search 
 all the nodes of a graph or tree level by level (i.e., first visit all immediate neighbors, then their neighbors, and so on). */

import java.util.*;

class Node {
    int value;
    List<Node> neighbors = new ArrayList<>();

    Node(int val) {
        this.value = val;
    }
}

public class GraphBFS {
    public static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start.value);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            for (Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor.value)) {
                    visited.add(neighbor.value);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create graph nodes
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        // Connect nodes (undirected)
        a.neighbors.add(b);
        a.neighbors.add(c);
        b.neighbors.add(a);
        b.neighbors.add(d);
        c.neighbors.add(a);
        d.neighbors.add(b);

        // Run BFS
        System.out.println("BFS Traversal:");
        bfs(a);
    }
}
/*
    1
   / \
  2   3
  |
  4

Initialization:
    Queue: [1]
    Visited: {1}
Iteration 1:
    Remove 1 from queue → print 1
    Add neighbors of 1 → 2 and 3 to queue
    Queue: [2, 3]
    Visited: {1, 2, 3}
Iteration 2:
    Remove 2 → print 2
    Neighbor of 2: 1 (already visited), 4 (new)
    Queue: [3, 4]
    Visited: {1, 2, 3, 4}
Iteration 3:
    Remove 3 → print 3
    Neighbors of 3: 1 (already visited)
    Queue: [4]
Iteration 4:
    Remove 4 → print 4
    Neighbor of 4: 2 (already visited)
    Queue becomes empty → BFS ends
 */
