package dp;

import java.util.Arrays;

public class RodCutting {
    public static int maxScore(int[] score) {
        int n = score.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                dp[j] = Math.max(dp[j], score[i] + dp[j - i - 1]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 3, 1, 6 };
        // int arr[] = { 2, 5, 7, 8, 10 };
        System.out.println(maxScore(arr));
    }
}
