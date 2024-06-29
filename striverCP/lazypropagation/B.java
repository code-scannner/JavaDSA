package striverCP.lazypropagation;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        int n = sc.nextInt(), q = sc.nextInt();
        int arr[] = sc.narr(n);

        solve(n, q, arr);

        out.close();
    }

    public static void solve(int n, int q, int arr[]) {
        int minIndex[] = new int[q + 1];
        int maxIndex[] = new int[q + 1];
        int zeroIndex = -1;
        Arrays.fill(minIndex, -1);
        Arrays.fill(maxIndex, -1);
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (num == 0) {
                zeroIndex = i;
                continue;
            }
            if (minIndex[num] == -1) {
                minIndex[num] = i;
            }
            maxIndex[num] = i;
        }

        // edge case - if last query cannot be inserted
        if (minIndex[q] == -1 && zeroIndex == -1) {
            out.println("NO");
            return;
        }

        if (minIndex[q] == -1) {
            arr[zeroIndex] = q;
        }

        int max = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
            if (arr[i] == 0)
                arr[i] = max;

        SegmentTree sg = new SegmentTree(arr, max);
        for (int i = 1; i <= q; i++) {
            if (minIndex[i] == -1 || maxIndex[i] == -1)
                continue;
            int min = sg.query(minIndex[i], maxIndex[i]);
            if (min < i) {
                out.println("NO");
                return;
            }
        }

        out.println("YES");

        for (int i = 1; i < n; i++)
            if (arr[i] == max)
                arr[i] = arr[i - 1];
        for (int i = n - 2; i >= 0; i--)
            if (arr[i] == max)
                arr[i] = arr[i + 1];

        for (int i = 0; i < n; i++) {
            out.print(arr[i] + " ");
        }
        out.println();
    }

    public static class SegmentTree {
        int seg[];
        int no_overlap_val = Integer.MAX_VALUE; // range queries for min value

        SegmentTree(int arr[], int no_overlap_value) {
            seg = new int[arr.length * 4];
            no_overlap_val = no_overlap_value;
            build(arr, 0, 0, arr.length - 1);
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

        // function used while finding the query values
        public int eval(int left, int right) {
            return Math.min(left, right);
        }

        public int query(int left, int right) {
            return query(0, 0, seg.length / 4 - 1, left, right);
        }

        private int query(int idx, int low, int high, int l, int r) {
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