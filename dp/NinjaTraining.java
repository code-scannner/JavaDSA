package dp;

import java.util.*;

public class NinjaTraining {
    public static int memoization(int dp[][], int merits[][], int day, int last) {
        if (last < 3 && dp[day][last] != -1)
            return dp[day][last];

        int max = Integer.MIN_VALUE;
        if (day == 0) {
            for (int i = 0; i < merits.length; i++) {
                if (i != last) {
                    max = Math.max(max, merits[day][i]);
                }
            }
        } else {

            for (int i = 0; i < merits.length; i++) {
                if (i != last) {
                    max = Math.max(max, merits[day][i] + memoization(dp, merits, day - 1, i));
                }
            }

        }
        if (last < 3) {
            dp[day][last] = max;
        }
        return max;
    }

    public static int tabulation(int merits[][]) {
        int m = merits.length, n = merits[0].length;
        int dp[][] = new int[m][n];
        for (int j = 0; j < n; j++)
            dp[0][j] = merits[0][j];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        max = Math.max(max, dp[i - 1][k]);

                    }
                }
                dp[i][j] = merits[i][j] + max;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int sum : dp[m - 1]) {
            max = Math.max(sum, max);
        }

        return max;

    }

    public static int space_optimized(int merits[][]) {
        int a0 = merits[0][0], a1 = merits[0][1], a2 = merits[0][2];

        for (int i = 1; i < merits.length; i++) {
            int temp0 = Math.max(a1, a2);
            int temp1 = Math.max(a0, a2);
            int temp2 = Math.max(a0, a1);
            a0 = merits[i][0] + temp0;
            a1 = merits[i][1] + temp1;
            a2 = merits[i][2] + temp2;
        }

        return Math.max(a0, Math.max(a1, a2));
    }

    public static void main(String[] args) {
        int merits[][] = {
                { 1, 2, 5 },
                { 3, 1, 1 },
                { 3, 3, 1 }
        };

        int dp[][] = new int[merits.length][merits.length];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        System.out.println(memoization(dp, merits, merits.length - 1, 3));
        System.out.println(tabulation(merits));
        System.out.println(space_optimized(merits));

    }
}
