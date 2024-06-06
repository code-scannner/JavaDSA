package striverCP.implement;

import java.util.*;
import java.io.*;

public class Q27 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            char[][] grid = sc.nstr(n, m);
            int cnt = 0;
            for (int i = 0; i < n - 1; i++) {
                if (grid[i][m - 1] == 'R')
                    cnt++;
            }
            for (int i = 0; i < m - 1; i++) {
                if (grid[n - 1][i] == 'D')
                    cnt++;
            }
            out.println(cnt);
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

        char[][] nstr(int n, int m) throws IOException {
            char result[][] = new char[n][m];
            for (int i = 0; i < n; i++)
                result[i] = next().toCharArray();
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