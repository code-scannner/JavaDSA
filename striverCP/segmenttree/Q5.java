package striverCP.segmenttree;

import java.util.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        int m = sc.nextInt();

        SegmentTree sg = new SegmentTree(arr);

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            out.println(sg.query(l - 1, r - 1));
        }

        out.close();
    }

    public static int hcf(int d, int rem) {
        if (rem == 0)
            return d;
        return hcf(rem, d % rem);
    }

    public static class SegmentTree {
        int seg[][];
        int no_overlap_val[] = { 0, 0 };

        SegmentTree(int arr[]) {
            seg = new int[arr.length * 4][2];
            build(arr, 0, 0, arr.length - 1);
        }

        private void build(int arr[], int idx, int low, int high) {
            if (low == high) {
                seg[idx][0] = arr[low];
                seg[idx][1] = 1;
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            build(arr, left, low, mid);
            build(arr, right, mid + 1, high);
            seg[idx] = eval(seg[left], seg[right]);
        }

        // function used while finding the query values
        public int[] eval(int[] left, int[] right) {
            int gcd = hcf(left[0], right[0]);
            int win = 0;
            if (gcd == left[0])
                win += left[1];
            if (gcd == right[0])
                win += right[1];
            return new int[] { gcd, win };
        }

        public int query(int left, int right) {
            return right - left + 1 - query(0, 0, seg.length / 4 - 1, left, right)[1];
        }

        private int[] query(int idx, int low, int high, int l, int r) {
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