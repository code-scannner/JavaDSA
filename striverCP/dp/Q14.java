package striverCP.dp;

import java.util.*;
import java.io.*;

public class Q14 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int team1[] = sc.narr(n);
        int team2[] = sc.narr(n);
        // long dp[][] = new long[n][2];
        // for (int i = 0; i < n; i++) {
        //     dp[i][0] = dp[i][1] = -1;
        // }
        
        // long result = memo(dp, team1, team2, 0, 0, n);
        // result = Math.max(result, memo(dp, team1, team2, 0, 1, n));

        // out.println(result);
        out.println(optimized(team1, team2, n));

        out.close();
    }

    public static long optimized(int a[], int b[], int n) {
        long r1 = a[n - 1], r2 = b[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            long nr1 = Math.max(r1, a[i] + r2);
            long nr2 = Math.max(r2, b[i] + r1);
            r1 = nr1;
            r2 = nr2;
        }
        return Math.max(r1, r2);
    }

    public static long memo(long[][] dp, int[] team1, int[] team2, int i, int prev, int n) {
        if (i >= n)
            return 0;
        if (dp[i][prev] != -1)
            return dp[i][prev];
        long res = memo(dp, team1, team2, i + 1, prev, n);
        res = Math.max(res, (prev == 0 ? team1[i] : team2[i]) + memo(dp, team1, team2, i + 1, 1 - prev, n));
        dp[i][prev] = res;
        return res;
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