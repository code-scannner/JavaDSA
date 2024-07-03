package striverCP.dp;

import java.util.*;
import java.io.*;

public class Q20 {

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), k = sc.nextInt();
        int dp[][] = new int[n + 1][k + 1];
        for (int arr[] : dp)
            Arrays.fill(arr, -1);
        int res = ((memo(dp, a, k, b, n) - memo(dp, a - 1, k, b, n))%mod + mod)%mod;
        out.println(res);
        out.close();
    }

    static int memo(int[][] dp, int a, int k, int b, int n) {
        if (k == 0)
            return a;
        if (a == 0)
            return 0;
        if (dp[a][k] != -1)
            return dp[a][k];

        long sum = 0;
        int diff = Math.abs(a - b) - 1;
        if (a > b) {
            sum = memo(dp, Math.min(a + diff, n), k - 1, b, n);
            sum = sum - memo(dp, b, k - 1, b, n);
        } else {
            sum = memo(dp, b - 1, k - 1, b, n);
            sum = sum - memo(dp, Math.max(0, a - diff - 1), k - 1, b, n);
        }

        sum -= memo(dp, a, k - 1, b, n);
        sum += memo(dp, a - 1, k - 1, b, n);
        sum += memo(dp, a - 1, k, b, n);

        int res = (int) (sum % mod + mod) % mod;

        dp[a][k] = res;
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