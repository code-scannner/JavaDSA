package dp;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int recursion(int d[], int i, int j) {
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int mults = recursion(d, i, k)
                    + recursion(d, k + 1, j)
                    + d[i - 1] * d[k] * d[j];
            min = Math.min(min, mults);
        }
        return min;
    }

    public static int memoization(int dp[][], int d[], int i, int j) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int mults = memoization(dp, d, i, k)
                    + memoization(dp, d, k + 1, j)
                    + d[i - 1] * d[k] * d[j];
            min = Math.min(min, mults);
        }

        dp[i][j] = min;

        return min;
    }

    public static int tabulation(int d[]) {
        int n = d.length;
        int dp[][] = new int[n][n];

        for (int i = n - 1; i>0 ; i--) {
            for (int j = i + 1; j<n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int mults = dp[i][k] + dp[k + 1][j] + d[i - 1] * d[k] * d[j];
                    min = Math.min(min, mults);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int d[] = { 5, 4, 8, 2 };
        // 

        System.out.println(recursion(d, 1, d.length - 1));

        int dp[][] = new int[d.length][d.length];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(memoization(dp, d, 1, d.length - 1));

        System.out.println(tabulation(d));
    }
}
