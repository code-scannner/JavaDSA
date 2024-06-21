package striverCP.fenwick;

import java.util.*;
import java.io.*;

public class Q2 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int x[] = sc.narr(n);
        int v[] = sc.narr(n);
        int xv[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            xv[i][0] = x[i];
            xv[i][1] = v[i];
        }

        out.println(count(xv));

        out.close();
    }

    public static long count(int xv[][]) {
        int n = xv.length;
        
        Arrays.sort(xv, (a, b) -> a[0] - b[0]);

        int index[] = indexedArray(xv);
        BinaryIndexedTree bit = new BinaryIndexedTree(n);
        BinaryIndexedTree counts = new BinaryIndexedTree(n);

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += (long)counts.sum(index[i] - 1)*xv[i][0] - bit.sum(index[i] - 1);
            bit.add(index[i], xv[i][0]);
            counts.add(index[i], 1);
        }
        return cnt;
    }

    public static int[] indexedArray(int arr[][]) {

        int n = arr.length;
        int index[][] = new int[n][2];
        for (int i = 0; i < n; i++)
            index[i] = new int[] { arr[i][1], i };

        Arrays.sort(index, (a, b) -> a[0] - b[0]);

        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[index[i][1]] = i + 1;
        }
        return res;
    }

    public static class BinaryIndexedTree {
        /// 1 indexed tree
        long index[];

        BinaryIndexedTree(int n) {
            index = new long[n + 1];
        }

        public void add(int i, int val) {
            i++; // 1 based indexing
            while (i < index.length) {
                index[i] += val;
                i += i & -i; // moving to child
            }
        }

        public long sum(int i) {
            i++; // 1 based indexing
            long s = 0;
            while (i > 0) {
                s += index[i];
                i -= i & -i; // moving to parent
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