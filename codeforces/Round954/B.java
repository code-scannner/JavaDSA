package codeforces.Round954;
import java.util.*;
import java.io.*;
public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int mat[][] = new int[n][m];
            for(int i = 0; i<n; i++) mat[i] = sc.narr(m);
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(isStrictlyGreater(i, j, mat, n, m)){
                        mat[i][j] = max(i, j, mat, n, m);
                    }
                }
            }

            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    out.print(mat[i][j] + " ");
                }
                out.println();
            }
        }

        out.close();
    }
    public static boolean isStrictlyGreater(int i, int j, int mat[][], int n, int m){
        if(i + 1 < n && mat[i + 1][j] >= mat[i][j]) return false;
        if(j + 1 < m && mat[i][j + 1] >= mat[i][j]) return false;
        if(i - 1 >= 0 && mat[i - 1][j] >= mat[i][j]) return false;
        if(j - 1 >= 0 && mat[i][j - 1] >= mat[i][j]) return false;
        return true;
    }
    
    public static int max(int i, int j, int mat[][], int n, int m){
        int mx = 0;
        if(i + 1 < n) mx = Math.max(mx, mat[i + 1][j]);
        if(j + 1 < m) mx = Math.max(mx, mat[i][j + 1]);
        if(i - 1 >= 0) mx = Math.max(mx, mat[i - 1][j]);
        if(j - 1 >= 0) mx = Math.max(mx, mat[i][j - 1]);
        return mx;
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