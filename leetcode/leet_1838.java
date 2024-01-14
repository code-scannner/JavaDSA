package leetcode;

import java.util.*;

public class leet_1838 {
    public static int maxFrequency(int arr[], int k) {
        long prefixSum = 0;
        int max = 0, j = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            long reqSum = (i - j + 1) * arr[i];
            while (j <= i && reqSum - prefixSum > k) {
                prefixSum -= arr[j++];
                reqSum = (i - j + 1) * arr[i];
            }
            max = Math.max(max, i - j + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 12 };

        System.out.println(maxFrequency(nums, 1));
    }
}
