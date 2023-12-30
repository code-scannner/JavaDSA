package dp;

import java.util.Arrays;

public class SubsetSumK {
    // Time Complexity = O(n*k) which is better than O(2^n)
    // space complexity = O(k)
    public static int count_sequences_sum_k(int arr[], int k) {
        int dp[] = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            int curr[] = new int[k + 1];
            for (int j = 0; j <= k; j++) {
                curr[j] = dp[j];
                if (j - arr[i] >= 0) {
                    curr[j] += dp[j - arr[i]];
                }
            }

            dp = curr;
        }

        return dp[k];
    }

    public static boolean check_sum(int arr[], int k) {
        boolean dp[] = new boolean[k + 1];
        dp[0] = true;
        for (int i = 0; i < arr.length; i++) {
            boolean curr[] = new boolean[k + 1];
            for (int j = 0; j <= k; j++) {
                boolean take = dp[j];
                boolean nottake = (j - arr[i]) >= 0 ? dp[j - arr[i]] : false;
                curr[j] = take | nottake;
            }

            if (curr[k])
                return true;

            dp = curr;
        }

        return false;

    }

    public static int minimumAbsoluteDifferenceEqualSubsets(int arr[]) {
        int k = Arrays.stream(arr).sum();
        boolean dp[] = new boolean[k + 1];
        dp[0] = true;
        for (int i = 0; i < arr.length; i++) {
            boolean curr[] = new boolean[k + 1];
            for (int j = 0; j <= k; j++) {
                boolean take = dp[j];
                boolean nottake = (j - arr[i]) >= 0 ? dp[j - arr[i]] : false;
                curr[j] = take | nottake;
            }

            dp = curr;
        }

        int sum = k / 2;
        while (sum >= 0) {
            if (dp[sum] && dp[k - sum])
                return k - 2 * sum;
        }

        return k;
    }

    public static int countPartitionWithDifferenceD(int arr[], int d) {
        int T = 0;
        for (int elem : arr) {
            T += elem;
        }
        return (T - d >= 0 && (T - d) % 2 == 0) ? count_sequences_sum_k(arr, (T - d) / 2) : 0;

    }

    public static int TargetSumOfDbyAlternateSign(int arr[], int k){
        k = Math.abs(k);
        return countPartitionWithDifferenceD(arr, k);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };

        System.out.println(count_sequences_sum_k(arr, 4));
        System.out.println(check_sum(arr, 4));

        int arrr[] = { 2, 3, 3, 4, 5 };
        System.out.println(minimumAbsoluteDifferenceEqualSubsets(arrr));

        int arrrr[] = { 5, 2, 6, 4, 1, 1 };
        System.out.println(countPartitionWithDifferenceD(arrrr, 3));

    }
}
