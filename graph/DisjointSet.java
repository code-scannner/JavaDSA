package graph;

import java.util.*;

public class DisjointSet {

    public static int[] createSet(int[][] edges, int V) {
        int set[] = new int[V];
        Arrays.fill(set, -1);

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            while (set[x] >= 0) {
                x = set[x];
            }
            while (set[y] >= 0) {
                y = set[y];
            }

            if (x == y)
                continue;

            if (set[x] < set[y]) {
                set[x] += set[y];
                set[y] = x;
            } else if (set[x] > set[y]) {
                set[y] += set[x];
                set[x] = y;
            }
        }

        return set;
    }

}
