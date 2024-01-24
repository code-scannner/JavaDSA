package graph;

import java.util.*;

public class CheckIfBinaryTree {

    public static boolean binaryTree(int edges[][], int V) {
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
                return false;

            if (set[x] < set[y]) {
                set[x] += set[y];
                set[y] = x;
            } else {
                set[y] += set[x];
                set[x] = y;
            }
        }

        System.out.println(Arrays.toString(set));
        ;

        int pCount = 0;

        for (int i = 0; i < V; i++) {
            if (set[i] < 0)
                pCount++;
        }
        if (pCount != 1)
            return false;

        int children[] = new int[V];
        for (int edge[] : edges) {
            children[edge[0]]++;
        }

        for (int child : children) {
            if (child > 2)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int N = 8;
        // int[][] G = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        // int[][] G = { { 0, 1 }, { 1, 2 }, { 1, 3 } };
        int[][] G = {
                { 3, 1 },
                { 7, 4 },
                { 3, 7 },
                { 3, 5 },
                { 0, 6 },
                { 3, 2 },
                { 0, 3 }
        };
        System.out.println(binaryTree(G, N));
    }
}
