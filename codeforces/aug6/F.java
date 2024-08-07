package codeforces.aug6;

import java.util.*;
import java.io.*;

public class F {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int arr[] = sc.narr(n);
            int zeros = 0, ones = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0)
                    zeros++;
                else
                    ones++;
            }
            long sum = 0;
            for (int i = (int) Math.ceil(k / 2.0); i <= k; i++) {
                sum += combination_mod(ones, i, mod) * combination_mod(zeros, k - i, mod) % mod;
            }

            out.println(sum);
        }

        out.close();
    }

    static int mod = (int) 1e9 + 7;
    static int max = (int) 2e5;

    static long[] fact = new long[max + 1];
    static {
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }
    }

    public static long pow(long n, int x, int range) {
        long result = 1L;
        while (x > 0) {
            if ((x & 1) == 1) {
                result = (result * n) % range;
            }
            n = n * n % range;
            x >>= 1;
        }

        return result;
    }

    public static long combination_mod(int n, int r, int mod) {
        if (n < r || n < 0 || r < 0)
            return 0;
        return fact[n] * pow((fact[n - r] * fact[r]) % mod, mod - 2, mod) % mod;
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