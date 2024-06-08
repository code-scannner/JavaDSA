package tree;

import graph.Graph;
import java.util.*;

public class DiameterUndirected {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, { 4, 2 },
                { 1, 4 },
                { 5, 4 },
                { 3, 4 } };
        List<List<Integer>> adj = Graph.undirectedAdjList(edges, n);
        int result = diameter(n, adj);
        System.out.println(result);
    }

    public static int diameter(int n, List<List<Integer>> adj) {
        int fartest = bfs(adj, 0)[1];
        return bfs(adj, fartest)[0];
    }

    // 0 - maxNodesInFarthestPath, 1 - FarthestNodeIndex
    public static int[] bfs(List<List<Integer>> adj, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { n, -1, 0 });
        int maxIdx = n;
        int max = 0;
        while (!q.isEmpty()) {
            int node[] = q.poll();
            for (int next : adj.get(node[0])) {
                if(next != node[1]){
                    if(max < node[2] + 1){
                        max = node[2] + 1;
                        maxIdx = next;
                    }
                    q.offer(new int[]{next, node[0], node[2] + 1});
                }
            }
        }

        return new int[] { max, maxIdx };

    }
}
