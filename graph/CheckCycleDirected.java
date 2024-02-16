package graph;

import java.util.*;

public class CheckCycleDirected {
    public static boolean _dfs(int node, List<List<Integer>> adj, int visited[]) {
        for (int i : adj.get(node)) {
            if (visited[i] == 2) {
                return true;
            }
            if (visited[i] == 0) {
                visited[i] = 2;
                if (_dfs(i, adj, visited))
                    return true;
                visited[i] = 1;
            }
        }

        return false;
    }

    public static boolean dfs(List<List<Integer>> adj) {
        int V = adj.size();
        int visited[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                visited[i] = 2;
                if (_dfs(i, adj, visited))
                    return true;
                visited[i] = 1;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int edges[][] = {
                { 1 },
                { 2 },
                { 3, 6 },
                { 4 },
                { 5 },
                {},
                { 4 },
                { 1, 8 },
                { 9 }, // {} for no cycle
                { 7 },
        };
        List<List<Integer>> adjMat = Graph.arrayToAdjList(edges, edges.length);
        System.out.println(dfs(adjMat));
    }
}
