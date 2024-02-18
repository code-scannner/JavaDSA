package leetcode;

import java.util.*;

public class leet_100200 {
    public static int memo(int dp[][], int[] nums, int i, int j, int sum) {
        if (j - i < 1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int max = 0;
        if (nums[i] + nums[i + 1] == sum) {
            max = Math.max(max, 1 + memo(dp, nums, i + 2, j, sum));
        }
        if (nums[j] + nums[j - 1] == sum) {
            max = Math.max(max, 1 + memo(dp, nums, i, j - 2, sum));
        }
        if (nums[i] + nums[j] == sum) {
            max = Math.max(max, 1 + memo(dp, nums, i + 1, j - 1, sum));
        }
        dp[i][j] = max;
        return max;
    }

    public static int maxOperations(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for (int is[] : dp)
            Arrays.fill(is, -1);
        int firstTwo = 1 + memo(dp, nums, 2, n - 1, nums[0] + nums[1]);
        for (int is[] : dp)
            Arrays.fill(is, -1);
        int lastTwo = 1 + memo(dp, nums, 0, n - 3, nums[n - 1] + nums[n - 2]);
        for (int is[] : dp)
            Arrays.fill(is, -1);
        int firstLast = 1 + memo(dp, nums, 1, n - 2, nums[0] + nums[n - 1]);
        return Math.max(firstLast, Math.max(lastTwo, firstTwo));
    }

    public static void main(String[] args) {
        int nums[] = { 3, 2, 6, 1, 4 };
        System.out.println(maxOperations(nums));
    }
}
