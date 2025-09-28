package tree;

import java.util.*;

public class LowestCommonAncestor {

    public static void lca_bst() {
        
    }

    public static void findDepth(List<List<Integer>> adj, int node, int[] depth, int d) {
        depth[node] = d;
        for (int next : adj.get(node)) {
            findDepth(adj, next, depth, d + 1);
        }
    }

    // query type: given (x, y) find the lca
    public static List<Integer> lca_queries(int parent[], int queries[][]) {

        List<Integer> ans = new ArrayList<>();
        int n = parent.length;

        // making adjacency list for the generic tree
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        // calculating depth
        int[] depth = new int[n];
        findDepth(adj, 0, depth, 0);

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
            int u = query[0], v = query[1];
            if (depth[u] < depth[v]) {
                int temp = u;
                u = v;
                v = temp;
            }

            int diff = depth[u] - depth[v];
            for (int i = 0; i < max; i++) {
                if (((diff >> i) & 1) == 1) {
                    u = table[i][u];
                }
            }

            if (u == v) {
                ans.add(u);
                continue;
            }

            for (int i = max - 1; i >= 0; i--) {
                if (table[i][u] != table[i][v]) {
                    u = table[i][u];
                    v = table[i][v];
                }
            }

            ans.add(table[0][u]);
        }

        return ans;
    }

    public static int lca_simple(int parent[], int p, int q) {
        List<Integer> path1 = new ArrayList<>(), path2 = new ArrayList<>();
        while (p != -1) {
            path1.add(p);
            p = parent[p];
        }
        while (q != -1) {
            path2.add(q);
            q = parent[q];
        }

        Collections.reverse(path1);
        Collections.reverse(path2);

        int ans = -1;
        for (int i = 0; i < path1.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                ans = path1.get(i);
            } else
                break;
        }

        return ans;

    }

    public static void main(String[] args) {
        int parent[] = { -1, 0, 0, 1, 1, 2, 2, 5, 5, 7, 7 };

        System.out.println(lca_simple(parent, 9, 6));
        System.out.println(lca_queries(parent, new int[][] { { 9, 6 }, { 10, 4 } }));
    }
}
