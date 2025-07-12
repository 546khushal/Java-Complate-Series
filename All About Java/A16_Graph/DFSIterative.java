import java.util.*;

public class DFSIterative {
    public static void dfsIterative(int start, List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        System.out.println("DFS (Iterative) starting from node " + start + ":");
        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");

                // Reverse the order to maintain DFS order like recursion
                List<Integer> neighbors = graph.get(current);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
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

        dfsIterative(0, graph, n);
    }
}
