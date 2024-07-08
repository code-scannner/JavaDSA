package striverCP.segmenttree;

import java.util.*;
import java.io.*;

public class Q7 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();

        int a[] = sc.narr(n), b[] = sc.narr(n);

        int arr[] = new int[n];
        Arrays.fill(arr, -1);
        int unassigned = Integer.MIN_VALUE;
        LazySetIndex lsg = new LazySetIndex(n, unassigned);

        while (m-- > 0) {
            if (sc.nextInt() == 1) {
                int x = sc.nextInt(), y = sc.nextInt(), k = sc.nextInt();
                // one based indexing so subtract 1
                lsg.set(y - 1, y + k - 2, x - y);
            } else {
                int x = sc.nextInt();
                int shift = lsg.query(x - 1);
                out.println(shift == unassigned ? b[x - 1] : a[x - 1 + shift]);
            }
        }

        out.close();
    }

    // Range set Point query
    static class LazySetIndex {
        int seg[];
        int lazy[];
        int unassigned;

        LazySetIndex(int n, int unassigned_val) {
            unassigned = unassigned_val;
            // -1 means the node is not set yet
            seg = new int[n * 4];
            // -1 means there is nothing to set now
            lazy = new int[n * 4];
            Arrays.fill(seg, unassigned);
            Arrays.fill(lazy, unassigned);
        }

        // set the pending values whenever visiting the node
        public void setLazy(int idx, int l, int r) {
            if (lazy[idx] == unassigned)
                return;
            seg[idx] = lazy[idx];
            if (l != r) {
                lazy[2 * idx + 1] = lazy[idx];
                lazy[2 * idx + 2] = lazy[idx];
            }
            lazy[idx] = unassigned;
        }

        // set the range from l to r with value
        public void set(int l, int r, int value) {
            set(0, 0, seg.length / 4 - 1, l, r, value);
        }

        private void set(int idx, int low, int high, int l, int r, int val) {

            setLazy(idx, low, high);

            // no overlap condition
            if (low > r || high < l) {
                return;
            }
            // complete overlap
            else if (l <= low && high <= r) {
                lazy[idx] = val;
                // updating here is important as we need the set value in the recursion
                setLazy(idx, low, high);
                return;
            }
            // partial overlap
            else {
                int mid = low + (high - low) / 2;
                int left = 2 * idx + 1;
                int right = left + 1;
                set(left, low, mid, l, r, val);
                set(right, mid + 1, high, l, r, val);
            }
        }

        public int query(int point) {
            return query(0, 0, seg.length / 4 - 1, point);
        }

        private int query(int idx, int low, int high, int point) {

            setLazy(idx, low, high);

            if (low == high) {
                return seg[idx];
            } else {
                int mid = low + (high - low) / 2;
                int left = 2 * idx + 1;
                int right = left + 1;
                if (point <= mid) {
                    return query(left, low, mid, point);
                } else
                    return query(right, mid + 1, high, point);
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