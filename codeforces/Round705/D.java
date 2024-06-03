package codeforces.Round705;

import java.util.*;
import java.io.*;


public class D {
    static int mod = (int)1e9 + 7;
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = sc.narr(n);
        SegmentTree sg = new SegmentTree(arr);
        while (q-- > 0) {
            int idx = sc.nextInt() - 1;
            int factor = sc.nextInt();
            sg.update(idx, factor);
            out.println(sg.query());
        }

        out.close();
    }
    static class SegmentTree {
        long seg[];
        long no_overlap_val = 0;
    
        SegmentTree(int arr[]) {
            seg = new long[arr.length * 4];
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
        public long eval(long left, long right) {
            return gcd(left, right);
        }
    
        public int query() {
            return (int)(seg[0] % mod);
        }
    
        // update the index value to another
        public void update(int index, int value) {
            update(0, 0, seg.length / 4 - 1, index, value);
        }
    
        private void update(int idx, int low, int high, int i, int val) {
            if (low == high) {
                seg[idx] = seg[idx] * val;
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
    
    }
    

    public static long gcd(long d, long rem) {
        if (rem == 0)
            return d;
        return gcd(rem, d % rem);
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

        int[][] matrix(int n, int m) throws IOException {
            int result[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                result[i] = narr(m);
            }
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