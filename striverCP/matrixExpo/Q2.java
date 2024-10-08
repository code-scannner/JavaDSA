package striverCP.matrixExpo;

import java.util.*;
import java.io.*;

public class Q2 {
    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        long n = sc.nextLong();
        int m = sc.nextInt();
        if (n < m)
            out.println(1);
        else {
            int matrix[][] = new int[m][m];
            matrix[0][0] = 1;
            matrix[0][m - 1] = 1;
            for (int i = 1; i < m; i++)
                matrix[i][i - 1] = 1;
            matrix = matPow(matrix, n - m + 1 , mod);
            long result = 0;
            for (int i = 0; i < m; i++) {
                result = (result + matrix[0][i]) % mod;
            }
            out.println(result);
        }

        out.close();
    }

    public static int[][] multiply(int[][] mat1, int[][] mat2, int mod) {
        int n = mat1.length;
        int res[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long val = 0;
                for (int k = 0; k < n; k++) {
                    val += ((long) mat1[i][k] * mat2[k][j]) % mod;
                }
                res[i][j] = (int) (val % mod);
            }
        }
        return res;
    }

    public static int[][] matPow(int[][] mat, long p, int range) {
        if (p == 0) {
            int n = mat.length;
            int base[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                base[i][i] = 1;
            }
            return base;
        }
        if (p == 1)
            return mat;
        int res[][] = matPow(mat, p / 2, range);
        int ans[][] = multiply(res, res, range);
        if (p % 2 == 1) {
            return multiply(ans, mat, range);
        }
        return ans;
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