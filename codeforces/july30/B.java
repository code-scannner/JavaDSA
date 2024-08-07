package codeforces.july30;

import java.util.*;

import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean grid[][] = new boolean[2][n];
            String top = sc.next();
            String bottom = sc.next();
            for (int i = 0; i < n; i++) {
                if (top.charAt(i) == '.')
                    grid[0][i] = true;
                if (bottom.charAt(i) == '.')
                    grid[1][i] = true;
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < 2; i++) {
                    if (j + 2 < n && !grid[i][j] && !grid[i][j + 2] && grid[i][j + 1]) {
                        if (i + 1 < 2 && grid[i + 1][j + 1]
                                && grid[i + 1][j] && grid[i + 1][j + 2]) {
                            count++;
                        }
                        if (i - 1 >= 0 && grid[i - 1][j]
                                && grid[i - 1][j + 1] && grid[i - 1][j + 2]) {
                            count++;
                        }
                    }
                }
            }

            out.println(count);

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