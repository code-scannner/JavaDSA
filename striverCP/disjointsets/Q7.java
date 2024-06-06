package striverCP.disjointsets;

import java.util.*;
import java.io.*;

public class Q7 {
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

        public long pairs() {
            long c = 0;
            for (int i = 0; i < set.length; i++) {
                if (set[i] < -1)
                    c += (long) -set[i] * (-set[i] - 1);
            }
            return c;
        }

        public int count(int node) {
            return -set[findParent(node)];
        }
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        DSU zeroSet = new DSU(t + 1);
        DSU oneSet = new DSU(t + 1);

        boolean zeroConnected[] = new boolean[t + 1];
        boolean oneConnected[] = new boolean[t + 1];

        while (t-- > 1) {
            int x = sc.nextInt(), y = sc.nextInt();
            if (sc.nextInt() == 1) {
                oneSet.union(x, y);
                oneConnected[x] = true;
                oneConnected[y] = true;
            } else {
                zeroConnected[x] = true;
                zeroConnected[y] = true;
                zeroSet.union(x, y);
            }
        }

        long result = oneSet.pairs();
        result += zeroSet.pairs();

        for (int i = 1; i < zeroConnected.length; i++) {
            if (zeroConnected[i] && oneConnected[i]) {
                result += (long) (zeroSet.count(i) - 1) * (oneSet.count(i) - 1);
            }
        }

        out.print(result);

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