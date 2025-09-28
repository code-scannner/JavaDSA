package graph;

import java.util.*;

public class ArticulationPoint {

    private static void dfs(int u, int parent, List<List<Integer>> adj,
            int[] visited, int[] disc, int[] low, int[] time, int[] isAP) {
        visited[u] = 1;
        disc[u] = low[u] = ++time[0];
        int children = 0;

        for (int v : adj.get(u)) {
            if (visited[v] == 0) {
                children++;
                dfs(v, u, adj, visited, disc, low, time, isAP);

                low[u] = Math.min(low[u], low[v]);

                if (parent != -1 && low[v] >= disc[u]) {
                    isAP[u] = 1;
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (parent == -1 && children > 1) {
            isAP[u] = 1;
        }
    }

    public static List<Integer> findArticulationPoints(int edges[][], int n) {
        // build adjacency list
        List<List<Integer>> adj = Graph.undirectedAdjList(edges, n);

        int[] disc = new int[n], low = new int[n];
        int[] visited = new int[n], isAP = new int[n];
        int[] time = { 0 };

        for (int u = 0; u < n; u++) {
            if (visited[u] == 0) {
                dfs(u, -1, adj, visited, disc, low, time, isAP);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isAP[i] == 1)
                result.add(i);
        }

        if (result.isEmpty())
            result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        // Example graph with articulation points: 0 and 3
        List<Integer> list = findArticulationPoints(edges, 5);
        System.out.println(list); // Expected: [0, 3]
    }
}
