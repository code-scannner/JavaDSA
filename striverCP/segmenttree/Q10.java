package striverCP.segmenttree;

import java.util.*;
import java.io.*;

public class Q10 {
    static int map [] = new int[(int)1e6 + 1];

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), q = sc.nextInt();
        
        map[1] = 1;
        for (int i = 1; i < map.length; i++) {
            for (int j = i; j < map.length; j += i) {
                map[j]++;
            }
        }
        

        int arr[] = sc.narr(n);
        SegmentTree sg = new SegmentTree(arr);


        while (q-- > 0) {
            int type = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt();
            if (type == 2) {
                out.println(sg.query(l - 1, r - 1));
            } else {
                sg.replace(l - 1, r - 1);
            }
        }

        out.close();
    }

    static class SegmentTree {
        long seg[][];

        SegmentTree(int arr[]) {
            seg = new long[arr.length * 4][2];
            build(arr, 0, 0, arr.length - 1);
        }

        private void build(int arr[], int idx, int low, int high) {
            if (low == high) {
                seg[idx][0] = arr[low];
                seg[idx][1] = arr[low];
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
        public long[] eval(long left[], long right[]) {
            return new long[] { left[0] + right[0], Math.max(left[1], right[1]) };
        }

        public long query(int left, int right) {
            return query(0, 0, seg.length / 4 - 1, left, right);
        }

        private long query(int idx, int low, int high, int l, int r) {
            // no overlap condition
            if (low > r || high < l) {
                return 0;
            }
            // complete overlap
            else if (l <= low && high <= r) {
                return seg[idx][0];
            }
            // partial overlap
            else {
                int mid = low + (high - low) / 2;
                int left = 2 * idx + 1;
                int right = left + 1;
                return query(left, low, mid, l, r) + query(right, mid + 1, high, l, r);
            }
        }

        // update the index value to another
        public void replace(int l, int r) {
            replace(0, 0, seg.length / 4 - 1, l, r);
        }

        private void replace(int idx, int low, int high, int l, int r) {
            // no overlap condition
            if(seg[idx][1] <= 2) return;

            if (low > r || high < l) {
                return;
            }
            // partial or full overlap
            else {
                if (low == high) {
                    seg[idx][1] = map[(int)seg[idx][1]];
                    seg[idx][0] = seg[idx][1];
                    return;
                }
                int mid = low + (high - low) / 2;
                int left = 2 * idx + 1;
                int right = left + 1;
                replace(left, low, mid, l, r);
                replace(right, mid + 1, high, l, r);
                seg[idx] = eval(seg[left], seg[right]);
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