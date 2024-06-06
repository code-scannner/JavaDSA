package striverCP.disjointsets;

import java.util.*;
import java.io.*;

public class Q8 {
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

        public long count(int n) {
            return -set[findParent(n)];
        }
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        DSU set = new DSU(n + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt(), w = sc.nextInt();
            pq.offer(new int[] { x, y, w });
        }
        int queries[][] = new int[m][2];
        long result[] = new long[m];
        for (int i = 0; i < m; i++) {
            queries[i][0] = i;
            queries[i][1] = sc.nextInt();
        }
        Arrays.sort(queries, (a, b) -> a[1] - b[1]);

        long currPairs = 0;

        for (int i = 0; i < m; i++) {
            while (!pq.isEmpty() && pq.peek()[2] <= queries[i][1]) {
                int node[] = pq.poll();
                currPairs += set.count(node[0]) * set.count(node[1]);
                set.union(node[0], node[1]);
            }
            result[queries[i][0]] = currPairs;
        }

        for (int i = 0; i < m; i++) {
            out.print(result[i] + " ");
        }

        out.close();
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