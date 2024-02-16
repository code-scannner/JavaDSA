package graph;

import java.util.*;

public class CheckBiparite {
    public static boolean _bfs(int node, List<List<Integer>> adjMat, int[] visited) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(node);
        while (!Q.isEmpty()) {
            int curr = Q.poll();
            for (int n : adjMat.get(curr)) {
                if (visited[n] == 0) {
                    visited[n] = -visited[curr];
                    Q.offer(n);
                } else if (visited[n] == visited[curr]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean bfs(List<List<Integer>> adjMat) {
        int V = adjMat.size();
        int colored[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (colored[i] == 0) {
                colored[i] = 1;
                if (!_bfs(i, adjMat, colored)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean _dfs(int node, List<List<Integer>> adjMat, int visited[], int flag) {
        for (int i : adjMat.get(node)) {
            if (visited[i] == 0) {
                visited[i] = flag;
                if (!_dfs(i, adjMat, visited, -flag)) {
                    return false;
                }
            } else if (visited[i] != flag) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(List<List<Integer>> adjMat) {
        int V = adjMat.size();
        int colored[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (colored[i] == 0) {
                colored[i] = 1;
                if (!_dfs(i, adjMat, colored, -1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int edges[][] = {
                { 1 },
                { 0, 2, 4 },
                { 1, 3 },
                { 2, 5 },
                { 1, 5 },
                { 4, 6, 3 },
                { 5 },
        };
        List<List<Integer>> adjMat = Graph.arrayToAdjList(edges, edges.length);
        System.out.println(bfs(adjMat));
        System.out.println(dfs(adjMat));
    }
}
