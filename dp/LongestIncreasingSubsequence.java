package dp;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static int recursion(int arr[], int i, int pi) {
        if (i == -1) {
            return 0;
        }
        int take = 0;
        if (pi == arr.length || arr[i] < arr[pi]) {
            take = 1 + recursion(arr, i - 1, i);
        }
        int nottake = recursion(arr, i - 1, pi);

        return Math.max(take, nottake);
    }

    public static int memoization(int arr[], int dp[][], int i, int previ) {

        if (i == -1) {
            return 0;
        }
        if (dp[i][previ] == -1) {
            int take = 0;
            if (previ == arr.length || arr[i] < arr[previ]) {
                take = 1 + memoization(arr, dp, i - 1, i);
            }
            int nottake = memoization(arr, dp, i - 1, previ);

            dp[i][previ] = Math.max(take, nottake);
        }

        return dp[i][previ];
    }

    public static int tabulation(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int maxL = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxL = Math.max(maxL, dp[i]);
        }

        return maxL;
    }

    public static List<Integer> printLIS(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int maxL = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxL = Math.max(maxL, dp[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = dp.length - 1; i >= 0; i--) {
            if (maxL == dp[i]) {
                list.add(arr[i]);
                maxL--;
            }
        }

        Collections.reverse(list);
        return list;

    }

    public static int countLIS(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        count[0] = 1;
        dp[0] = 1;
        int maxL = 1, maxCount = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    if (dp[i] < 1 + dp[j]) {
                        count[i] = count[j];
                        dp[i] = 1 + dp[j];
                    } else if (dp[i] == 1 + dp[j]) {
                        count[i] += count[j];
                    }
                }
            }
            // if this elem is part of longest, then only we update the maxCount
            if (maxL < dp[i]) {
                maxL = dp[i];
                maxCount = count[i];
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 3, 2, 6, 7, 10, 8, 9 };
        int n = nums.length;
        System.out.println(recursion(nums, n - 1, n));

        int dp[][] = new int[n + 1][n + 1];
        for (int d[] : dp)
            Arrays.fill(d, -1);

        System.out.println(memoization(nums, dp, n - 1, n));

        System.out.println(tabulation(nums));

        System.out.println(printLIS(nums));

        System.out.println(countLIS(nums));
    }
}
