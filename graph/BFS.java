package graph;

import java.util.*;

public class BFS {
    public static List<Integer> bfs(List<List<Integer>> adj) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> traverse = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited.contains(i)) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    traverse.add(node);
                    visited.add(node);
                    for (int n : adj.get(node)) {
                        if (!visited.contains(n)) {
                            q.offer(n);
                        }
                    }
                }
            }
        }
        return traverse;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = Graph.adjList(new int[][] {
                { 0, 2 }, { 2, 0 }
        }, 3);
        System.out.println(bfs(list));
    }
}
