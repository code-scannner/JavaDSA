package striverCP.lazypropagation;

import java.util.*;
import java.io.*;

public class Q1 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        SegmentTree sg = new SegmentTree(arr);
        int m = sc.nextInt();
        while (m-- > 0) {
            String str[] = sc.nextLine().split(" ");
            int lf = Integer.parseInt(str[0]), rg = Integer.parseInt(str[1]);
            if (str.length == 3) {
                int v = Integer.parseInt(str[2]);
                if (lf <= rg) {
                    sg.update(lf, rg, v);
                } else {
                    sg.update(lf, n - 1, v);
                    sg.update(0, rg, v);
                }
            } else {
                if (lf <= rg) {
                    out.println(sg.query(lf, rg));
                } else {
                    out.println(Math.min(sg.query(lf, n - 1), sg.query(0, rg)));
                }
            }
        }

        out.close();
    }

    static class SegmentTree {
        long seg[];
        long lazy[];
        int no_overlap_val = Integer.MAX_VALUE;

        SegmentTree(int arr[]) {
            seg = new long[arr.length * 4];
            lazy = new long[arr.length * 4];
            build(arr, 0, 0, arr.length - 1);
        }

        public long eval(long left, long right) {
            return Math.min(left, right);
        }

        private void build(int arr[], int idx, int low, int high) {
            if (low == high) {
                seg[idx] = arr[low];
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            build(arr, left, low, mid);
            build(arr, right, mid + 1, high);
            seg[idx] = eval(seg[left], seg[right]);
        }

        // update the pending values whenever visiting the node
        public void updateLazy(int idx, int l, int r) {
            seg[idx] += lazy[idx];
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