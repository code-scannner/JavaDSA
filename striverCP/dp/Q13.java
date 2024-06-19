package striverCP.dp;

import java.util.*;
import java.io.*;

public class Q13 {
    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), k = sc.nextInt();
        int dp[][] = new int[k + 1][n + 1];
        for (int arr[] : dp)
            Arrays.fill(arr, -1);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = (sum + memo(dp, i, k, n)) % mod;
        }
        
        out.println(sum);
        // out.println(tabu(n, k));
        out.close();
    }

    public static int tabu(int n, int k){
        int dp[][] = new int[n + 1][k + 1];
        for(int i = 0; i<=n; i++) dp[i][1] = 1;
        for(int i = 0; i<=k; i++) dp[n][i] = 1;
        for(int i = n - 1; i>0; i--){
            for(int j = 2; j<=k; j++){
                for(int l = i;l<=n;l+=i){
                    dp[i][j] = (dp[i][j] + dp[l][j - 1])%mod;
                }
            }
        }

        int sum = 0;
        for(int i = 1; i<=n; i++) sum = (sum + dp[i][k])%mod;
        return sum;

    }

    public static int memo(int[][] dp, int i, int k, int n) {
        if (i > n)
            return 0;
        if (k == 1)
            return 1;
        if (dp[k][i] != -1)
            return dp[k][i];
        int sum = 0;
        for (int j = i; j <= n; j += i) {
            sum = (sum + memo(dp, j, k - 1, n)) % mod;
        }
        dp[k][i] = sum;

        return sum;
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