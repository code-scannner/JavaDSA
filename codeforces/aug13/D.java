package codeforces.aug13;

import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = sc.narr(n);
            char[] str = sc.next().toCharArray();
            long score = 0;
            long prefixSum[] = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                prefixSum[i] += prefixSum[i - 1] + arr[i - 1];
            }
            int i = 0, j = n - 1;
            while (i <= j) {
                while (i < n && str[i] != 'L')
                    i++;
                while (j >= 0 && str[j] != 'R')
                    j--;
                if (i <= j) {
                    score += prefixSum[j + 1] - prefixSum[i];
                }
                i++;
                j--;
            }

            out.println(score);

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