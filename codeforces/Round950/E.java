package codeforces.Round950;

import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[][] = sc.matrix(n, m);
            int b[][] = sc.matrix(n, m);

            out.println(isPossible(a, b, n, m) ? "YES" : "NO");

        }

        out.close();
    }

    public static boolean isPossible(int a[][], int b[][], int n, int m) {
        int rowNumber[] = new int[n * m + 1];
        int colNumber[] = new int[n * m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowNumber[a[i][j]] = i;
                colNumber[a[i][j]] = j;
            }
        }

        for (int i = 0; i < n; i++) {
            int rowN = rowNumber[b[i][0]];
            for(int j = 1; j<m; j++){
                if(rowN != rowNumber[b[i][j]]) return false;
            }
        }
        for (int j = 0; j < m; j++) {
            int colN = colNumber[b[0][j]];
            for(int i = 1; i < n; i++){
                if(colN != colNumber[b[i][j]]) return false;
            }
        }

        return true;

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

        int[][] matrix(int n, int m) throws IOException {
            int result[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                result[i] = narr(m);
            }
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