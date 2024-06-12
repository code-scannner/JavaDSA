package codeforces.Round952;

import java.util.*;
import java.io.*;

public class G {

    public static int pow(int n, int x, int range) {
        long result = 1L;
        while (x > 0) {
            if ((x & 1) == 1) {
                result = (result * n) % range;
            }
            n = (int) (((long) n * n) % range);
            x >>= 1;
        }

        return (int) result;
    }

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int l = sc.nextInt(), r = sc.nextInt(), k = sc.nextInt();
            int pow[] = { 0, 10, 5, 4, 3 };
            int p = 2;
            if (k < 5) {
                p = pow[k];
            }

            if (k >= 10)
                out.println(0);
            else {
                long res = pow(p, r, mod);
                res = res - pow(p, l, mod) + mod;
                res = res % mod;
                out.println(res);
            }
        }

        out.close();
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