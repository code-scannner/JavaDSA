package dp;

import java.util.*;

public class KnapSack {
    public static int recursion(int[] wt, int[] val, int i, int bag) {
        if (bag < 0)
            return Integer.MIN_VALUE;

        if (bag == 0)
            return 0;

        if (i == 0)
            return wt[0] <= bag ? val[0] : Integer.MIN_VALUE;

        int keep = recursion(wt, val, i - 1, bag - wt[i]) + val[i];
        int leave = recursion(wt, val, i - 1, bag);

        return Math.max(keep, leave);

    }

    public static int memorization(int[] wt, int[] val, int dp[][], int i, int bag) {

        if (bag < 0)
            return Integer.MIN_VALUE;

        if (bag == 0)
            return 0;

        if (i >= 0 && dp[i][bag] != -1)
            return dp[i][bag];

        if (i == 0) {
            dp[0][bag] = wt[0] <= bag ? val[0] : Integer.MIN_VALUE;
        } else {
            int keep = memorization(wt, val,dp, i - 1, bag - wt[i]) + val[i];
            int leave = memorization(wt, val,dp, i - 1, bag);
            dp[i][bag] = Math.max(keep, leave);

        }
        return dp[i][bag];
    }

    public static int tabulation(int[] wt, int[] val, int bag) {
        int dp[] = new int[bag + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int j = wt[0]; j <= bag; j++) {
            dp[j] = val[0];
        }

        for (int i = 1; i < wt.length; i++) {
            int curr[] = new int[bag + 1];
            for (int j = 1; j <= bag; j++) {
                int keep = (j - wt[i]) >= 0 ? dp[j - wt[i]] + val[i] : Integer.MIN_VALUE;
                int leave = dp[j];
                curr[j] = Math.max(keep, leave);
            }
            dp = curr;
        }

        return dp[bag];
    }

    public static int space_optimized(int wt[], int val[], int bag) {
        int dp[] = new int[bag + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int j = wt[0]; j <= bag; j++) {
            dp[j] = val[0];
        }

        for (int i = 1; i < wt.length; i++) {
            for (int j = bag; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }

        return dp[bag];
    }

    public static void main(String[] args) {
        int wt[] = { 3, 4, 5 };
        int val[] = { 30, 50, 60 };
        int bag = 9;
        System.out.println(recursion(wt, val, wt.length - 1, bag));

        int dp[][] = new int[wt.length][bag + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(memorization(wt, val, dp, wt.length - 1, 9));
        for(int [] is : dp){
            System.out.println(Arrays.toString(is));
        }

        System.out.println(tabulation(wt, val, bag));
        System.out.println(space_optimized(wt, val, bag));

    }
}