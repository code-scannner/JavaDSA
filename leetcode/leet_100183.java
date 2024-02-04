package leetcode;

import java.util.*;

public class leet_100183 {
    public static long maximumSubarraySum(int[] nums, int k) {
        long prefixSum = 0, max = Long.MIN_VALUE;
        Map<Integer, Long> map = new HashMap<Integer, Long>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(nums[i] + k)) {
                max = Math.max(max, prefixSum - map.get(nums[i] + k));
            }
            if (map.containsKey(nums[i] - k)) {
                max = Math.max(max, prefixSum - map.get(nums[i] - k));
            }
            map.put(nums[i], Math.min(prefixSum - nums[i], map.getOrDefault(nums[i], Long.MAX_VALUE)));
        }
        if(max == Long.MIN_VALUE) return 0;
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5 };
        int k = 2;
        System.out.println(maximumSubarraySum(arr, k));
    }

}