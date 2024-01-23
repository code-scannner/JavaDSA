package graph;

import java.util.*;

public class DFS {
    public static void dfs(int node, List<List<Integer>> adj, Set<Integer> visited, List<Integer> ans) {
        for (int c : adj.get(node)) {
            if (!visited.contains(c)) {
                ans.add(c);
                visited.add(c);
                dfs(c, adj, visited, ans);
            }
        }
    }

    public static List<Integer> dfs(List<List<Integer>> adj) {
        int V = adj.size();
        List<Integer> ans = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < V; i++) {
            if (!visited.contains(i)) {
                ans.add(i);
                visited.add(i);
                dfs(i, adj, visited, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = Graph.adjMatrix(new int[][] {
                { 1, 2 }
        }, 3);
        System.out.println(dfs(list));
    }
}
