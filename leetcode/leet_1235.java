package leetcode;

import java.util.*;

public class leet_1235 {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int[][] multidim = new int[startTime.length][3];
        for (int i = 0; i < multidim.length; i++) {
            multidim[i][0] = startTime[i];
            multidim[i][1] = endTime[i];
            multidim[i][2] = profit[i];
        }

        Arrays.sort(multidim, (as, bs) -> as[0] - bs[0]);

        int n = multidim[multidim.length - 1][0];

        int dp[] = new int[n + 2];
        int i = n, j = multidim.length - 1;
        while (j >= 0) {
            if (i == multidim[j][0]) {
                int max = 0, interval = multidim[j][0];
                while (j >= 0 && multidim[j][0] == interval) {
                    max = Math.max(max, multidim[j][2] + (multidim[j][1] <= n ? dp[multidim[j][1]] : 0));
                    j--;
                }
                dp[interval] = Math.max(max, dp[interval + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
            i--;
        }

        return dp[i + 1];
    }
    public static void main(String[] args) {
        // int[] startTime = { 1, 2, 3, 3 }, endTime = { 3, 4, 5, 6 }, profit = { 50,
        // 10, 40, 70 };
        int[] startTime = { 1, 2, 3, 4, 6 }, endTime = { 3, 5, 10, 6, 9 }, profit = { 20, 20, 100, 70, 60 };
        int result = jobScheduling(startTime, endTime, profit);
        System.out.println(result);
    }
}
