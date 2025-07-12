import java.util.*;

public class BFSGraph {
    public static void bfs(int start, List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        System.out.println("BFS Traversal starting from node " + start + ":");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 6; // Number of nodes (0 to 5)
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected Graph Example
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(2).add(0);
        graph.get(2).add(4);
        graph.get(3).add(1);
        graph.get(4).add(2);
        graph.get(4).add(5);
        graph.get(5).add(4);

        bfs(0, graph, n); // Start BFS from node 0
    }
}
