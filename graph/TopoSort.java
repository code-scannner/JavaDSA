package graph;

import java.util.*;

public class TopoSort {
    public static void dfs(int node, List<List<Integer>> adj, Stack<Integer> stk, boolean[] visited) {
        if (visited[node])
            return;
        visited[node] = true;
        for (int i : adj.get(node)) {
            dfs(i, adj, stk, visited);
        }
        stk.push(node);
    }

    public static List<Integer> topoLogicalOrder(List<List<Integer>> adj) {
        boolean visited[] = new boolean[adj.size()];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfs(i, adj, stk, visited);
            }
        }
        List<Integer> order = new ArrayList<>();
        while (!stk.isEmpty()) {
            order.add(stk.pop());
        }
        return order;
    }

    public static List<Integer> bfs(List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int n = adj.size();
        int indegree[] = new int[n];
        for (List<Integer> to : adj) {
            for (int node : to) {
                indegree[node]++;
            }
        }
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for (int i : adj.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        if(order.size() != n) System.out.println("Cycle Detected");

        return order;
    }

    public static void main(String[] args) {
        int adjMat[][] = {
                {},
                {},
                { 3 },
                { 1 },
                { 0, 1 },
                { 0, 2 },
        };
        List<List<Integer>> adjList = Graph.arrayToAdjList(adjMat, 6);
        System.out.println(topoLogicalOrder(adjList));
        System.out.println(bfs(adjList));
        adjMat = new int[][]{
            {1},
            {2},
            {3},
            {4,5},
            {2},
            {}
        };
        adjList = Graph.arrayToAdjList(adjMat, 6);
        System.out.println(bfs(adjList));
    }
}
