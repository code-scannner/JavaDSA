package striverCP.fenwick;

import java.util.*;
import java.io.*;

// MEMORY LIMIT EXCEEDED RESOLVED USING BETTER nextInt() method

public class Q7 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int q = sc.nextInt();

        BinaryIndexedTree bit = new BinaryIndexedTree(n + 1);
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            bit.add(x, 1);
        }

        while (q-- > 0) {
            int query = sc.nextInt();
            if (query < 0) {
                // remove that
                int index = binarySearch(bit, -query, n);
                bit.add(index, -1);
            } else {
                bit.add(query, 1);
            }
        }
        int ans = binarySearch(bit, 1, n);
        System.out.println(ans == n + 1 ? 0 : ans);
    }

    static int binarySearch(BinaryIndexedTree bit, int k, int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = (right + left) >> 1;
            int ans = bit.sum(mid);
            if (ans >= k) {
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return left;
    }

    static class BinaryIndexedTree {
        // 0 indexed tree
        int bit[];

        BinaryIndexedTree(int n) {
            bit = new int[n];
        }

        public void add(int i, int val) {
            while (i < bit.length) {
                bit[i] += val;
                i |= (i + 1); // moving to next segment
            }
        }

        public int sum(int i) {
            int s = 0;
            while (i > 0) {
                s += bit[i];
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
            int out = 0;
            boolean neg = false;
            while (true) {
                int get = br.read();
                if (get == -1)
                    break;
                char a = (char) get;
                if (a == '-')
                    neg = true;
                else if (a >= '0' && a <= '9') {
                    out *= 10;
                    out += a - '0';
                } else if (out != 0)
                    break;
            }
            if (neg)
                out = -out;
            return out;
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