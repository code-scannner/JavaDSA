package striverCP.segmenttree;

import java.util.*;
import java.io.*;

public class Q2 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        SegmentTree sg = new SegmentTree(arr, n);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int l = sc.nextInt(), r = sc.nextInt();
                int x = sc.nextInt();
                // find is it possible to make range gcd = x;
                out.println(sg.isPossible(l - 1, r - 1, x) ? "YES" : "NO");
            } else {
                // updating value type == 2
                sg.update(sc.nextInt() - 1, sc.nextInt());
            }
        }

        out.close();
    }

    static class SegmentTree {
        int seg[];
        int no_overlap_val = 1;

        SegmentTree(int arr[], int n) {
            seg = new int[arr.length * 4];
            build(arr, 0, 0, arr.length - 1);
        }

        public static int hcf(int d, int rem) {
            if (rem == 0)
                return d;
            return hcf(rem, d % rem);
        }

        public int eval(int left, int right) {
            return hcf(left, right);
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

        // update the index value to another
        public void update(int index, int value) {
            update(0, 0, seg.length / 4 - 1, index, value);
        }

        private void update(int idx, int low, int high, int i, int val) {
            if (low == high) {
                seg[idx] = val;
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            if (i <= mid)
                update(left, low, mid, i, val);
            else
                update(right, mid + 1, high, i, val);
            seg[idx] = eval(seg[left], seg[right]);
        }

        private int isPossible(int idx, int low, int high, int x, int l, int r) {
            // no overlap condition
            if (low > r || high < l) {
                return 0;
            }
            // complete overlap
            else if (l <= low && high <= r) {
                int left = 2 * idx + 1;
                int right = left + 1;
                int mid = low + (high - low) / 2;
                int cnt = 0;
                boolean leftDivisible = left >= seg.length || hcf(seg[left], x) == x;
                boolean rightDivisible = right >= seg.length || hcf(seg[right], x) == x;
                if (!leftDivisible && !rightDivisible)
                    return 2;
                if (!leftDivisible)
                    cnt += isPossible(left, low, mid, x, l, r);
                else if (!rightDivisible)
                    cnt += isPossible(right, mid + 1, high, x, l, r);
                else {
                    return hcf(seg[idx], x) == x ? 0 : 1;
                }
                return cnt;
            }
            // partial overlap
            else {
                int mid = low + (high - low) / 2;
                int left = 2 * idx + 1;
                int right = left + 1;
                int cnt = isPossible(left, low, mid, x, l, r);
                if (cnt > 1)
                    return cnt;
                cnt += isPossible(right, mid + 1, high, x, l, r);
                return cnt;
            }
        }

        public boolean isPossible(int l, int r, int x) {
            return isPossible(0, 0, seg.length / 4 - 1, x, l, r) <= 1;
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