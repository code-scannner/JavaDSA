package codeforces.july26;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            char[] a = sc.next().toCharArray(), b = sc.next().toCharArray();

            int[][] precompute1 = new int[n + 1][26];
            int[][] precompute2 = new int[n + 1][26];
            for (int i = 0; i < n; i++) {
                int ac = a[i] - 'a', bc = b[i] - 'a';
                precompute1[i + 1][ac]++;
                precompute2[i + 1][bc]++;
                for (int c = 0; c < 26; c++) {
                    precompute1[i + 1][c] += precompute1[i][c];
                    precompute2[i + 1][c] += precompute2[i][c];
                }
            }

            while (q-- > 0) {
                int l = sc.nextInt(), r = sc.nextInt();
                out.println(compute(l, r, precompute1, precompute2));
            }
        }

        out.close();
    }

    public static int compute(int l, int r, int[][] precompute1, int[][] precompute2) {
        int f1[] = new int[26];
        int f2[] = new int[26];
        for (int c = 0; c < 26; c++) {
            f1[c] += precompute1[r][c] - precompute1[l - 1][c];
            f2[c] += precompute2[r][c] - precompute2[l - 1][c];
        }

        // System.out.println(Arrays.toString(f1));
        // System.out.println(Arrays.toString(f2));

        int cnt = 0;
        for(int i = 0; i<26; i++){
            cnt += Math.abs(f1[i] - f2[i]);
        }

        return cnt/2;
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