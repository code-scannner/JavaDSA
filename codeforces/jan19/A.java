package codeforces.jan19;

import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int[] a = sc.narr(4);
            int c1 = a[0] + a[1], c2 = a[2] - a[1], c3 = a[3] - a[2];
            int l1 = fib(a[0], a[1], c1, a[2], a[3]);
            int l2 = fib(a[0], a[1], c2, a[2], a[3]);
            int l3 = fib(a[0], a[1], c3, a[2], a[3]);
            System.out.println(Math.max(Math.max(l1, l2), l3));
        }

        out.close();
    }

    public static int fib(int a, int b, int c, int d, int e) {
        int t = 0;
        if (e == c + d)
            t++;
        if (d == b + c)
            t++;
        if (c == a + b)
            t++;
        return t;
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