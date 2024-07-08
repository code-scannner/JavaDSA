package striverCP.lazypropagation;

import java.util.*;
import java.io.*;

public class Q2 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        SegmentTree sg = new SegmentTree(arr);
        int m = sc.nextInt();
        while (m-- > 0) {
            int type = sc.nextInt();
            int l = sc.nextInt(), r = sc.nextInt();
            if (type == 1) {
                out.println(sg.query(l - 1, r - 1));
            } else {
                int x = sc.nextInt();
                sg.update(l - 1, r - 1, x);
            }
        }

        out.close();
    }

    static class SegmentTree {
        int seg[][];
        boolean lazy[][];
        int no_overlap_val[] = new int[20];

        SegmentTree(int arr[]) {
            seg = new int[arr.length * 4][20];
            lazy = new boolean[arr.length * 4][20];
            build(arr, 0, 0, arr.length - 1);
        }

        public int[] eval(int[] left, int[] right) {
            int res[] = new int[20];
            for (int i = 0; i < 20; i++) {
                res[i] = left[i] + right[i];
            }
            return res;

        }

        private void build(int arr[], int idx, int low, int high) {
            if (low == high) {
                seg[idx] = new int[20];
                for (int i = 0; i < 20; i++) {
                    if ((arr[low] & (1 << i)) != 0) {
                        seg[idx][i] = 1;
                    }
                }
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
            int n = r - l + 1;
            int left = 2 * idx + 1;
            int right = left + 1;
            for (int i = 0; i < 20; i++) {
                if (lazy[idx][i]) {
                    seg[idx][i] = n - seg[idx][i];
                    if (l != r) {
                        lazy[left][i] = !lazy[left][i];
                        lazy[right][i] = !lazy[right][i];
                    }
                    lazy[idx][i] = false;
                }
            }
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
                for (int i = 0; i < 20; i++) {
                    if ((val & (1 << i)) != 0) {
                        lazy[idx][i] = !lazy[idx][i];
                    }
                }
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
            int[] res = query(0, 0, seg.length / 4 - 1, left, right);
            long ans = 0;
            for (int i = 0; i < 20; i++) {
                ans += res[i] * (long) Math.pow(2, i);
            }
            return ans;
        }

        private int[] query(int idx, int low, int high, int l, int r) {

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