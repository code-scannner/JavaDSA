package striverCP.segmenttree;

import java.util.*;
import java.io.*;

public class Q8 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();
        LazySegmentTree lsg = new LazySegmentTree(n);
        int queries[][] = new int[m][3];
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt(), r = sc.nextInt(), q = sc.nextInt();
            lsg.update(l - 1, r - 1, q);
            queries[i] = new int[] { l - 1, r - 1, q };
        }
        boolean isPossible = true;
        for (int i = 0; i < m; i++) {
            if (lsg.query(queries[i][0], queries[i][1]) != queries[i][2]) {
                isPossible = false;
            }
        }

        if (!isPossible)
            out.println("NO");
        else {
            out.println("YES");
            for (int i = 0; i < n; i++) {
                out.print(lsg.query(i, i) + " ");
            }
            out.println();
        }

        out.close();
    }

    static class LazySegmentTree {
        int seg[];
        int lazy[];
        int no_overlap_val = (1 << 30) - 1;

        LazySegmentTree(int n) {
            seg = new int[n * 4];
            lazy = new int[n * 4];
            Arrays.fill(seg, no_overlap_val);
            Arrays.fill(lazy, no_overlap_val);
        }

        // function used while adding left and right intervals
        public int eval(int left, int right) {
            return left & right;
        }

        // update the pending values whenever visiting the node
        public void updateLazy(int idx, int l, int r) {
            seg[idx] = seg[idx] & lazy[idx];
            if (l != r) {
                lazy[2 * idx + 1] &= lazy[idx];
                lazy[2 * idx + 2] &= lazy[idx];
            }
            lazy[idx] = no_overlap_val;
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
                lazy[idx] = val;
                // updating here is important as we need the update value in the recursion
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

        public int query(int left, int right) {
            return query(0, 0, seg.length / 4 - 1, left, right);
        }

        private int query(int idx, int low, int high, int l, int r) {

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