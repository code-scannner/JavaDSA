package dp;

import java.util.*;

public class LargestDivisibleSubset {
    public static int recursion(int arr[], int i) {
        if (i == 0)
            return 1;
        int max = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (arr[i] % arr[j] == 0) {
                max = Math.max(max, 1 + recursion(arr, j));
            }
        }
        return Math.max(max, recursion(arr, i - 1));
    }

    public static int memo(int dp[], int arr[], int i) {
        if (i == 0)
            return 1;

        if (dp[i] != -1)
            return dp[i];

        int max = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (arr[i] % arr[j] == 0) {
                max = Math.max(max, 1 + memo(dp, arr, j));
            }
        }
        dp[i] = Math.max(max, memo(dp, arr, i - 1));
        return dp[i];
    }

    public static int memoization(int arr[]) {
        Arrays.sort(arr);
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        int result = memo(dp, arr, dp.length - 1);
        return result;
    }

    public static int tabulation(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] % arr[j] == 0) {
                    max = Math.max(max, 1 + dp[j]);
                }
            }
            dp[i] = Math.max(max, dp[i - 1]);
        }

        return dp[n - 1];
    }

    public static List<Integer> printSubset(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(hash, -1);
        dp[0] = 1;
        int lastIndex = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] % arr[j] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        while(lastIndex != -1){
            list.add(arr[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 8, 19 };
        Arrays.sort(arr);
        System.out.println(recursion(arr, arr.length - 1));
        System.out.println(memoization(arr));
        System.out.println(tabulation(arr));
        System.out.println(printSubset(arr));
    }
}
