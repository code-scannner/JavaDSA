package striverCP.dp;

import java.util.*;
import java.io.*;

public class Q12 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextInt();
            int arr[] = sc.narr(n);

            // out.println(usingDp(arr, n));
            out.println(greedy(arr, n));
        }

        out.close();
    }

    public static long greedy(int arr[], int n) {
        long ans = 0;
        boolean plus = true;
        for (int i = 0; i < n - 1; i++) {
            if (plus && arr[i] > arr[i + 1]) {
                ans += arr[i];
                plus = !plus;
            } else if (!plus && arr[i] < arr[i + 1]) {
                ans -= arr[i];
                plus = !plus;
            }
        }
        if (plus)
            ans += arr[n - 1];
        return ans;
    }

    public static long usingDp(int arr[], int n) {
        long dp[][] = new long[n + 1][2];
        // dp[][0] + , dp[][1] -
        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = Math.max(dp[i + 1][0], arr[i] + dp[i + 1][1]);
            dp[i][1] = Math.max(dp[i + 1][1], -arr[i] + dp[i + 1][0]);
        }
        return dp[0][0];
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