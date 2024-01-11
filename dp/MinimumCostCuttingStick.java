package dp;

import java.util.*;

public class MinimumCostCuttingStick {
    public static int recursion(int stick[], int i, int j, int l) {
        if (j - i == 1)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            min = Math.min(min,
                    recursion(stick, i, k, l) + recursion(stick, k, j, l));
        }

        int left = 0, right = l;
        if (i != 0)
            left = stick[i - 1];
        if (j != stick.length + 1)
            right = stick[j - 1];

        return min + right - left;
    }

    public static int memoization(int dp[][], int stick[], int i, int j, int l) {
        if (j - i == 1)
            return 0;

        if (dp[i][j - 2] != -1)
            return dp[i][j - 2];

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            min = Math.min(min,
                    memoization(dp, stick, i, k, l) + memoization(dp, stick, k, j, l));
        }

        int left = 0, right = l;
        if (i != 0)
            left = stick[i - 1];
        if (j != stick.length + 1)
            right = stick[j - 1];

        dp[i][j - 2] = min + right - left;
        return dp[i][j - 2];
    }

    public static int tabulation(int stick[], int l) {
        int n = stick.length;
        int dp[][] = new int[n + 2][n + 2];

        for (int i = dp.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < dp.length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    min = Math.min(min,
                            dp[i][k] + dp[k][j]);
                }

                int left = 0, right = l;
                if (i != 0)
                    left = stick[i - 1];
                if (j != stick.length + 1)
                    right = stick[j - 1];
                
                dp[i][j] = min + right - left;
            }
        }

        return dp[0][dp.length - 1];
    }

    public static void main(String[] args) {
        int stick[] = { 3, 5, 1, 4 };
        Arrays.sort(stick);

        int l = 7;

        System.out.println(recursion(stick, 0, stick.length + 1, l));

        int dp[][] = new int[stick.length][stick.length];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(memoization(dp, stick, 0, stick.length + 1, l));

        
        System.out.println(tabulation(stick, l));

    }
}
