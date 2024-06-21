package striverCP.fenwick;

import java.util.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        int max = 0;
        BinaryIndexedTree bit = new BinaryIndexedTree(n + 1);
        for (int i = n - 1; i >= 0; i--) {
            int m = bit.max(n - arr[i]);
            max = Math.max(max, 1 + m);
            bit.add(n - arr[i] + 1, m + 1);
        }

        out.println(max);

        out.close();
    }

    public static class BinaryIndexedTree {
        // 0 indexed tree
        int bit[];

        BinaryIndexedTree(int n) {
            bit = new int[n];
        }
        
        public void add(int i, int val) {
            while (i < bit.length) {
                bit[i] = Math.max(bit[i], val);
                i |= (i + 1); // moving to next segment
            }
        }

        public int max(int i) {
            int s = 0;
            while (i > 0) {
                s = Math.max(s, bit[i]);
                i = (i & (i + 1)) - 1; // moving to previous segment
            }
            return s;
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