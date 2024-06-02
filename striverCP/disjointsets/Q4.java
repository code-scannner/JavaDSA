package striverCP.disjointsets;

import java.util.*;
import java.io.*;

public class Q4 {

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

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        DSU set = new DSU(n);
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            set.union(k - 1, i);
        }
        int max = Integer.MIN_VALUE, smax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (set.set[i] < 0) {
                int val = -set.set[i];
                cnt += (long) val * val;
                if (val > max) {
                    smax = max;
                    max = val;
                } else if (val > smax) {
                    smax = val;
                }
            }
        }
        if (smax != Integer.MIN_VALUE) {
            cnt -= (long) max * max;
            cnt -= (long) smax * smax;
            cnt += (long) (max + smax) * (max + smax);
        }

        out.println(cnt);

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