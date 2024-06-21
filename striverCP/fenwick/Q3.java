package striverCP.fenwick;

import java.util.*;
import java.io.*;

public class Q3 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        usingLazySegmentTree(n, sc, out);

        out.close();
    }

    // public static void usingFenwickTree(int n, Scanner sc, PrintWriter out) throws IOException {
    //     while (n-- > 0) {
    //         int type = sc.nextInt();
    //         if (type == 1) {
    //             int ai = sc.nextInt();
    //             int xi = sc.nextInt();
    //         } else if (type == 2) {
    //             int ki = sc.nextInt();

    //         } else {

    //         }
    //     }
    // }

    public static void usingLazySegmentTree(int n, Scanner sc, PrintWriter out) throws IOException {
        int size = 1;
        LazySegmentTree lsg = new LazySegmentTree(n + 1);
        while (n-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int ai = sc.nextInt();
                int xi = sc.nextInt();
                lsg.update(0, ai - 1, xi);
            } else if (type == 2) {
                size++;
                int ki = sc.nextInt();
                lsg.update(size - 1, size - 1, ki);
            } else {
                int lastVal = (int) lsg.query(size - 1, size - 1);
                lsg.update(size - 1, size - 1, -lastVal);
                size--;
            }
            out.printf("%f.6", (double) lsg.query(0, size - 1) / size);
        }
    }

    public static class LazySegmentTree {
        long seg[];
        int lazy[];
        int no_overlap_val = 0; // range queries for sum value

        LazySegmentTree(int n) {
            seg = new long[n * 4];
            lazy = new int[n * 4];
        }

        // function used while adding left and right intervals
        public long eval(long left, long right) {
            return left + right;
        }

        // update the pending values whenever visiting the node
        public void updateLazy(int idx, int l, int r) {
            if (lazy[idx] == 0)
                return;
            seg[idx] += (r - l + 1) * (lazy[idx]);
            if (l != r) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }

        // update the range from l to r adding with value
        public void update(int l, int r, int value) {
            update(0, 0, seg.length / 4 - 1, l, r, value);
        }

        private void update(int idx, int low, int high, int l, int r, int val) {

            updateLazy(idx, low, high);

            // no overlap condition
            if (low > r || high < l) {
                return;
            }
            // complete overlap
            else if (l <= low && high <= r) {
                lazy[idx] += val;
                updateLazy(idx, low, high);
                return;
            }
            // partial overlap
            else {
                int mid = low + (high - low) / 2;
                int left = 2 * idx + 1;
                int right = left + 1;
                update(left, low, mid, l, r, val);
                update(right, mid + 1, high, l, r, val);
                seg[idx] = eval(seg[left], seg[right]);
            }
        }

        public long query(int left, int right) {
            return query(0, 0, seg.length / 4 - 1, left, right);
        }

        private long query(int idx, int low, int high, int l, int r) {

            // visit to low - high updates the node
            updateLazy(idx, low, high);

            // no overlap condition
            if (low > r || high < l) {
                return no_overlap_val;
            }
            // complete overlap
            else if (l <= low && high <= r) {
                return seg[idx];
            }
            // partial overlap
            else {
                int mid = low + (high - low) / 2;
                int left = 2 * idx + 1;
                int right = left + 1;
                return eval(query(left, low, mid, l, r), query(right, mid + 1, high, l, r));
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