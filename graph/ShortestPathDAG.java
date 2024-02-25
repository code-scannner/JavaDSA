package graph;

import java.util.*;

public class ShortestPathDAG {
    public static int[] topologicalBFS(int[][] edges, int V, int src) {

        List<List<List<Integer>>> adj = Graph.edgesToWeightAdjList(edges, V);

        Queue<Integer> q = new LinkedList<>();
        int n = adj.size();
        int result[] = new int[n];
        Arrays.fill(result, (int) 1e9 + 7);
        result[src] = 0;

        int indegree[] = new int[n];
        for (List<List<Integer>> to : adj) {
            for (List<Integer> node : to) {
                indegree[node.get(0)]++;
            }
        }

        q.offer(src);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (List<Integer> d : adj.get(node)) {
                int newval = result[node] + d.get(1);
                int dest = d.get(0);

                if (newval < result[dest]) {
                    result[dest] = newval;
                }
                indegree[dest]--;
                if (indegree[dest] == 0) {
                    q.offer(dest);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int edges[][] = {
                { 0, 1, 2 },
                { 1, 3, 1 },
                { 2, 3, 3 },
                { 4, 0, 3 },
                { 4, 2, 1 },
                { 5, 4, 1 },
                { 6, 4, 2 },
                { 6, 5, 3 }
        };
        int result[] = topologicalBFS(edges, 7, 6);
        System.out.println(Arrays.toString(result));
    }
}
