package graph;

import java.util.*;

class Pair {
    int node;
    int parent;

    Pair(int _n, int _p) {
        node = _n;
        parent = _p;
    }
}

public class CheckCycleUndirected {

    public static boolean bfs(List<List<Integer>> adj, int V) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && _bfs(adj, i, V, visited)) {
                return true;
            }
        }

        return false;
    }

    public static boolean _bfs(List<List<Integer>> adj, int node, int V, boolean visited[]) {
        Queue<Pair> q = new LinkedList<>();
        visited[node] = true;
        q.offer(new Pair(node, -1));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int curr = pair.node;
            int parent = pair.parent;

            for (int n : adj.get(curr)) {
                if (n != parent) {
                    if (visited[n])
                        return true;
                    else {
                        visited[n] = true;
                        q.offer(new Pair(n, curr));
                    }
                }
            }
        }

        return false;
    }

    public static boolean _dfs(List<List<Integer>> adj, boolean[] visited, int node, int parent) {

        for (int i : adj.get(node)) {
            if (i != parent) {
                if (visited[i])
                    return true;
                visited[i] = true;
                if (_dfs(adj, visited, i, node))
                    return true;
            }
        }

        return false;
    }

    public static boolean dfs(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (_dfs(adj, visited, i, i))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 1 },
                { 2, 3 },
                { 1, 5 },
                { 1, 4, 6 },
                { 3 },
                { 2, 7 },
                { 3, 7 },
                { 5, 6 }
        };
        List<List<Integer>> adjList = Graph.arrayToAdjList(graph, graph.length);

        System.out.println(bfs(adjList, adjList.size()));
        System.out.println(dfs(adjList, adjList.size()));

    }
}
