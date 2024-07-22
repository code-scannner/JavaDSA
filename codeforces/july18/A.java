package codeforces.july18;

import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                mat[i] = sc.narr(m);
            }
            if (n == 1 && m == 1)
                out.println(-1);
            else {
                int left = 0, right = n * m - 1;
                while (left <= right) {
                    int x1 = left / m, y1 = left % m;
                    int x2 = right / m, y2 = right % m;
                    if (left == right) {
                        x1 = 0;
                        y1 = 0;
                    }
                    int temp = mat[x1][y1];
                    mat[x1][y1] = mat[x2][y2];
                    mat[x2][y2] = temp;
                    left++;
                    right--;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        out.print(mat[i][j] + " ");
                    }
                    out.println();
                }
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