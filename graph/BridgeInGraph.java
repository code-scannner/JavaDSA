package graph;

import java.util.*;

// Intution - 
// keeping track of time at which node is visited in time[];
// keeping track of minTime at which node can be visited other than parent;
// logic --> if the child's minTime cannot be less or equal than time of parent then this is the critical edge


public class BridgeInGraph {
    public static void dfs(int node, int parent, int i, List<List<Integer>> adj, int[] time, boolean visited[],
            int[] minTime, List<int[]> result) {
        visited[node] = true;
        time[node] = i;
        minTime[node] = i;
        for (int next : adj.get(node)) {
            if (next == parent)
                continue;
            if (!visited[next]) {
                dfs(next, node, i + 1, adj, time, visited, minTime, result);
            }
            if (time[node] < minTime[next]) {
                result.add(new int[] { node, next });
            }
            minTime[node] = Math.min(minTime[node], minTime[next]);
        }
    }

    public static List<int[]> criticalEdges(int edges[][], int n) {
        List<int[]> result = new ArrayList<>();
        List<List<Integer>> adj = Graph.undirectedAdjList(edges, n);
        int time[] = new int[n];
        boolean visited[] = new boolean[n];
        int minTime[] = new int[n];
        dfs(0, -1, 0, adj, time, visited, minTime, result);
        return result;
    }

    public static void main(String[] args) {
        // int edges[][] = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 } };
        int edges[][] = { {0,1},{1,2},{1,4},{2,3},{4,3},{4,5},{5,6},{6,7},{6,9},{7,8},{9,8},{8,10},{10,11},{12,10},{12,11} };
        List<int[]> list = criticalEdges(edges, 13);
        for (int l[] : list)
            System.out.println(Arrays.toString(l));
    }
}
