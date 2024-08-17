package codeforces.aug11;

import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = sc.narr(n);
            int b[] = sc.narr(n);

            if (matches(a, b) || matches(a, reverse(b)))
                out.println("Bob");
            else
                out.println("Alice");

        }

        out.close();
    }

    public static boolean matches(int arr[], int arr2[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static int[] reverse(int arr[]) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[n - i - 1];
        }
        return res;
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