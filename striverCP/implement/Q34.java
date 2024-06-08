package striverCP.implement;

import java.util.*;
import java.io.*;

public class Q34 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        
        for (int i = 0; i <= n; i++) {
            printSpaces(Math.abs(n - i) * 2, out);
            out.println(f(i));
        }
        for (int i = n - 1; i >= 0; i--) {
            printSpaces(Math.abs(n - i) * 2, out);
            out.println(f(i));
        }

        out.close();
    }

    public static void printSpaces(int n, PrintWriter out) {
        for (int j = n; j > 0; j--)
            out.print(" ");
    }

    public static String f(int n) {
        if(n == 0) return "0";
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= n; i++)
            str.append(i + " ");
        for (int i = n - 1; i >= 0; i--)
            str.append(i + (i == 0 ? "" : " "));
        return str.toString();
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