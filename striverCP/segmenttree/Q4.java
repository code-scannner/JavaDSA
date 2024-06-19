package striverCP.segmenttree;

import java.util.*;
import java.io.*;

// TODO: TIME LIMIT EXCEEDED

public class Q4 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        char[] bracket = sc.next().toCharArray();
        SegmentTree sg = new SegmentTree(bracket);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            out.println(2 * sg.query(l - 1, r - 1));
        }

        out.close();
    }

    static class SegmentTree {
        int seg[][];
        int[] no_overlap_val = { 0, 0, 0 };

        SegmentTree(char[] bracket) {
            seg = new int[bracket.length * 4][3];
            build(bracket, 0, 0, bracket.length - 1);
        }

        private void build(char[] bracket, int idx, int low, int high) {
            if (low == high) {
                seg[idx][bracket[low] == '(' ? 0 : 1] = 1;
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            build(bracket, left, low, mid);
            build(bracket, right, mid + 1, high);
            seg[idx] = eval(seg[left], seg[right]);
        }

        public int[] eval(int[] left, int[] right) {
            int[] res = new int[3];
            int full = Math.min(left[0], right[1]);
            res[0] = left[0] + right[0] - full; // for open
            res[1] = left[1] + right[1] - full; // for close
            res[2] = left[2] + right[2] + full; // for full
            return res;
        }

        public int query(int left, int right) {
            return query(0, 0, seg.length / 4 - 1, left, right)[2];
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
                int mid = (high + low) / 2;
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