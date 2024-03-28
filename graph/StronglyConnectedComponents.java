package graph;

import java.util.*;

// LOGIC -- 
// comp1 --> comp2 --> comp3 --> comp4
// sort the components by their finish time 
// the component which is ending at last should be traversed first by dfs

public class StronglyConnectedComponents {
    public static void dfs(int node, boolean visited[], Queue<Integer> q, List<List<Integer>> adj) {
        for (int next : adj.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, visited, q, adj);
            }
        }
        q.offer(node);
    }

    public static void dfs(int node, boolean visited[], List<Integer> list, List<List<Integer>> adj) {
        list.add(node);
        for (int next : adj.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, visited, list, adj);
            }
        }
    }

    public static List<List<Integer>> sccs(int[][] edges, int n) {
        List<List<Integer>> adj = Graph.adjList(edges, n);
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, visited, q, adj);
            }
        }
        visited = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            if (!visited[node]) {
                visited[node] = true;
                List<Integer> list = new ArrayList<>();
                dfs(node, visited, list, adj);
                result.add(list);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int edges[][] = {
                { 0, 1 }, { 1, 2 }, { 2, 0 },
                { 2, 3 },
                { 3, 4 },
                { 4, 5 }, { 5, 6 }, { 6, 4 },
                { 6, 7 }, { 4, 7 }
        };

        System.out.println(sccs(edges, 8));
    }
}
