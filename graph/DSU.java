package graph;

import java.util.*;

public class DSU {
    int set[];

    DSU(int size) {
        set = new int[size];
        Arrays.fill(set, -1);
    }

    public int findParent(int node) {
        if (set[node] < 0)
            return node;
        // path compressssion
        return set[node] = findParent(set[node]);
    }

    public void union(int node1, int node2) {
        node1 = findParent(node1);
        node2 = findParent(node2);
        if (node1 == node2) // already connected
            return;

        if (set[node1] <= set[node2]) {
            set[node1] += set[node2];
            set[node2] = node1;
        } else {
            set[node2] += set[node1];
            set[node1] = node2;
        }
    }
}
