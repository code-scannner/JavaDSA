package striverCP.disjointsets;

import java.util.*;
import java.io.*;

public class Q6 {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        int[] longestPath = new int[n + 1];
        DSU set = new DSU(n + 1);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
            set.union(a, b);
        }

        for (int i = 1; i <= n; i++) {
            if (set.set[i] < 0) {
                longestPath[i] = diameter(adj, i);
            }
        }

        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                out.println(longestPath[set.findParent(x)] + " ");
            } else {
                int x = sc.nextInt(), y = sc.nextInt();
                int px = set.findParent(x), py = set.findParent(y);
                if (px != py) {
                    int path = Math.max(Math.max(longestPath[px], longestPath[py]), (longestPath[px] + 1) / 2 + (longestPath[py] + 1) / 2 + 1);
                    set.union(x, y);
                    longestPath[set.findParent(x)] = path;
                }
            }
        }

        out.close();
    }

    public static int diameter(List<List<Integer>> adj, int node) {
        int fartest = bfs(adj, node)[1];
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
                if (next != node[1]) {
                    if (max < node[2] + 1) {
                        max = node[2] + 1;
                        maxIdx = next;
                    }
                    q.offer(new int[] { next, node[0], node[2] + 1 });
                }
            }
        }

        return new int[] { max, maxIdx };

    }

    static class DSU {
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

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }

        int[] narr(int n) throws IOException {
            int result[] = new int[n];
            for (int i = 0; i < n; i++)
                result[i] = nextInt();
            return result;
        }

        String[] nstr(int n) throws IOException {
            String result[] = new String[n];
            for (int i = 0; i < n; i++)
                result[i] = next();
            return result;
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }

        boolean ready() throws IOException {
            return br.ready();
        }
    }
}