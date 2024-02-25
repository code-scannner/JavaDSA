package graph;

import java.util.*;

public class DSU {
    int set[];

    DSU(int size) {
        set = new int[size];
        Arrays.fill(set, -1);
    }

    public int find(int node) {
        while (set[node] >= 0) {
            node = set[node];
        }
        return node;
    }

    public void union(int node1, int node2) {
        while (set[node1] >= 0)
            node1 = set[node1];
        while (set[node2] >= 0)
            node2 = set[node2];
        if (node1 == node2)
            return;

        if (set[node1] < set[node2]) {
            set[node1] += set[node2];
            set[node2] = node1;
        } else {
            set[node2] += set[node1];
            set[node1] = node2;
        }
    }
}
