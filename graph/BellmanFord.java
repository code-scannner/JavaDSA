package graph;

import java.util.*;

public class BellmanFord {
    // for directed graphs,
    // for undirected graph convert to directed
    // to detect negative cycles in graphs
    public static int[] bellmanFord(int n, int edges[][], int src) {
        int dis[] = new int[n];
        int MAX = (int) 1e9;
        Arrays.fill(dis, MAX);
        dis[src] = 0;
        for (int i = 0; i < n; i++) {
            boolean relaxed = false;
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int wgt = edge[2];
                if (dis[from] != MAX && dis[from] + wgt < dis[to]) {
                    dis[to] = dis[from] + wgt;
                    relaxed = true;
                }
            }
            if (!relaxed)
                break;
            if (relaxed && i == n - 1)
                return new int[] { -1 };
        }

        return dis;
    }

    public static void main(String[] args) {
        int edges[][] = {
                { 3, 2, 6 },
                { 5, 3, 1 },
                { 0, 1, 5 },
                { 1, 5, -3 },
                { 1, 2, -2 },
                // { 2, 1, -6 }, // adding to create cycle in the graph
                { 3, 4, -2 },
                { 2, 4, 3 }
        };
        int dis[] = bellmanFord(6, edges, 0);
        System.out.println(Arrays.toString(dis));
    }
}
