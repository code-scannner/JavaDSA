package tree;

import java.util.*;
import java.io.*;

public class DiameterDirectedTree {
    public static int usingTopoSort(int parent[]) {
        int n = parent.length;
        int outdegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                outdegree[parent[i]]++;
            }
        }

        int d = 0;
        int maxHeight[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0)
                q.offer(i);
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            int p = parent[node];
            if (p != -1) {
                d = Math.max(d, 1 + maxHeight[p] + 1 + maxHeight[node]);
                maxHeight[p] = Math.max(1 + maxHeight[node], maxHeight[p]);
                if (--outdegree[p] == 0) {
                    q.offer(p);
                }
            }
        }

        return Math.max(0, d - 1);
    }

    public static int usingDFS(int parent[]) {
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1)
                adj.get(parent[i]).add(i);
        }

        int[] d = new int[1];
        maxHeight(d, adj, 0);

        return Math.max(0, d[0] - 1);
    }

    public static int maxHeight(int d[], List<List<Integer>> adj, int node) {
        int max = 0;
        for (int next : adj.get(node)) {
            int nextHeight = maxHeight(d, adj, next);
            d[0] = Math.max(d[0], max + nextHeight + 1);
            max = Math.max(max, nextHeight);
        }

        return 1 + max;

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int parent[] = { -1, 3, 3, 0, 3 };
        System.out.println(usingTopoSort(parent));
        System.out.println(usingDFS(parent));

        sc.close();

    }

}