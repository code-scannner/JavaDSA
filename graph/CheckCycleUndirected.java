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

    public static boolean bfs(int graph[][], int V) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && _bfs(graph, V, visited)) {
                return true;
            }
        }

        return false;
    }

    public static boolean _bfs(int graph[][], int V, boolean visited[]) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int node = pair.node;
            visited[node] = true;
            for (int n : graph[node]) {
                if (n != pair.parent) {
                    if (visited[n])
                        return true;
                    else
                        q.offer(new Pair(n, node));
                }
            }
        }

        return false;
    }

    public static boolean _dfs(int graph[][], boolean[] visited, int node, int parent) {

        if (visited[node]) {
            return false;
        }

        visited[node] = true;

        for (int i : graph[node]) {
            if (i != parent && _dfs(graph, visited, i, node)) {
                return true;
            }
        }

        return false;
    }

    public static boolean dfs(int graph[][], int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && _dfs(graph, visited, 0, 0)) {
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

        System.out.println(bfs(graph, 8));
        System.out.println(dfs(graph, 8));

    }
}
