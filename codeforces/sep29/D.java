package codeforces.sep29;

import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();

            DSU uf = new DSU(n + 1);

            for (int i = 0; i < m; ++i) {
                int a = sc.nextInt(), d = sc.nextInt(), k = sc.nextInt();

                int lst = a + k * d;
                for (int j = 0; j < k; ++j) {
                    int curr = a + j * d;
                    uf.union(curr, curr + d);
                }

                uf.union(a, lst);
            }

            out.println(uf.connectedComponents());
        }

        out.close();
    }

    public static class DSU {
        int set[];

        DSU(int size) {
            set = new int[size];
            Arrays.fill(set, -1);
        }

        public boolean isParent(int node) {
            return set[node] < 0;
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

        public boolean areConnected(int node1, int node2) {
            return findParent(node1) == findParent(node2);
        }

        public int connectedComponents() {
            int cnt = 0;
            for (int i = 1; i < set.length; i++) {
                if (set[i] < 0)
                    cnt++;
            }
            return cnt;
        }

        public int connectedElements(int node) {
            return -set[findParent(node)];
        }

        public int largestComponentSize() {
            int max = 0;
            for (int i = 0; i < set.length; i++) {
                if (set[i] < 0)
                    max = Math.max(max, -set[i]);
            }
            return max;
        }
    }

    public static double precise(double a) {
        return Math.round(a * 1000000) / 1000000;
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

        void sort(int arr[]) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                list.add(arr[i]);
            Collections.sort(list);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
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