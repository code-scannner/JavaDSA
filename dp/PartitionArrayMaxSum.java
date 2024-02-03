package dp;

import java.util.*;

public class PartitionArrayMaxSum {

    public static int recursion(int arr[], int i, int k) {
        if (i == arr.length)
            return 0;
        int end = Math.min(arr.length, i + k);
        int max = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;
        for (int m = i; m < end; m++) {
            max = Math.max(max, arr[m]);
            result = Math.max(result,
                    max * (m - i + 1) + recursion(arr, m + 1, k));
        }
        return result;
    }

    public static int memo(int dp[], int arr[], int i, int k) {
        if (i == arr.length)
            return 0;
        if(dp[i] != - 1) return dp[i];
        int max = Integer.MIN_VALUE;
        int end = Math.min(arr.length, i + k);
        int result = Integer.MIN_VALUE;
        for (int m = i; m < end; m++) {
            max = Math.max(max, arr[m]);
            result = Math.max(result, max * (m - i + 1) + memo(dp, arr, m + 1, k));
        }
        dp[i] = result;
        return result;
    }

    public static int memoization(int arr[], int k) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        return memo(dp, arr, 0, k);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        System.out.println(recursion(arr, 0, k));
        System.out.println(memoization(arr, k));
    }
}
