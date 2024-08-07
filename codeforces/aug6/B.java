package codeforces.aug6;

import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int a1 = sc.nextInt(), a2 = sc.nextInt(), b1 = sc.nextInt(), b2 = sc.nextInt();
            int cnt = 0;
            cnt += wins(a1, a2, b1, b2);
            cnt += wins(a1, a2, b2, b1);
            cnt += wins(a2, a1, b1, b2);
            cnt += wins(a2, a1, b2, b1);
            out.println(cnt);
        }

        out.close();
    }

    public static int wins(int a1, int a2, int b1, int b2) {
        int firstwin = 0, secondwin = 0;
        if (a1 > b1)
            firstwin++;
        else if (b1 > a1)
            secondwin++;

        if (a2 > b2)
            firstwin++;
        else if (b2 > a2)
            secondwin++;

        return firstwin > secondwin ? 1 : 0;
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