
package striverCP.segmenttree;

import java.util.*;
import java.io.*;

public class Q1 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();
        int arr[] = sc.narr((1<<n));
        SegmentTree sg = new SegmentTree(arr, n);
        for (int i = 0; i < m; i++) {
            sg.update(sc.nextInt() - 1, sc.nextInt());
            out.println(sg.val());
        }

        out.close();
    }

    static class SegmentTree {
        int seg[];
        int orFirst;
        int no_overlap_val = 0;

        SegmentTree(int arr[], int n) {
            orFirst = n % 2;
            seg = new int[arr.length * 4];
            build(arr, 0, 0, arr.length - 1, orFirst);
        }

        private void build(int arr[], int idx, int low, int high, int or) {
            if (low == high) {
                seg[idx] = arr[low];
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            build(arr, left, low, mid, 1 - or);
            build(arr, right, mid + 1, high, 1 - or);
            seg[idx] = eval(seg[left], seg[right], or);
        }

        public int val() {
            return seg[0];
        }

        // update the index value to another
        public void update(int index, int value) {
            update(0, 0, seg.length / 4 - 1, index, value, orFirst);
        }

        private void update(int idx, int low, int high, int i, int val, int or) {
            if (low == high) {
                seg[idx] = val;
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            if (i <= mid)
                update(left, low, mid, i, val, 1 - or);
            else
                update(right, mid + 1, high, i, val, 1 - or);
            seg[idx] = eval(seg[left], seg[right], or);
        }

        public int eval(int left, int right, int or) {
            return or == 1 ? left | right : left ^ right;
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