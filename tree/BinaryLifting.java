package tree;

import java.util.*;

// kth ancestor question
// there is one generic tree, and queries which asks for kth ancestor of a node.

public class BinaryLifting {

    public static List<Integer> kthAncestor(int[] parent, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        int n = parent.length;

        // preprocessing
        int max = (int) (Math.log(n) / Math.log(2)) + 1;
        int[][] table = new int[max][n];
        for (int j = 0; j < n; j++)
            table[0][j] = parent[j];

        for (int i = 1; i < max; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i - 1][j] != -1)
                    table[i][j] = table[i - 1][table[i - 1][j]];
                else
                    table[i][j] = -1;
            }
        }

        for (int[] query : queries) {
            int node = query[0], k = query[1];
            int idx = 0;
            // going to the ancestor in log() time.
            while (k > 0 && node != -1) {
                // if lowest bit is 1, going to the 2^idx th ancestor
                if ((k&1) == 1) {
                    node = table[idx][node];
                }
                k >>= 1;
                idx++;
            }
            ans.add(node);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] parent = { -1, 0, 0, 1, 3, 2, 3 };
        int queries[][] = {
                { 1, 2 },
                { 2, 1 },
                { 4, 2 },
                { 4, 3 },
                { 4, 5 }
        };
        System.out.println(kthAncestor(parent, queries));
    }
}