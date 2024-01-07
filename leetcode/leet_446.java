package leetcode;

import java.util.*;

public class leet_446 {
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        int sum = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        // map = value, indexes of previous occurence

        for (int i = 0 ;i<nums.length;i++) {
            int num = nums[i];
            if(!map.containsKey(num)){
                map.put(num, new ArrayList<>(2));
            }
            map.get(num).add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int prev = 2*nums[j] - nums[i];
                if(map.containsKey(prev)){
                    int count = 0;
                    for (int k : map.get(prev)) {
                        if(k >= j) break;
                        count += 1 + dp[j][k];
                    }
                    dp[i][j] = count;
                    sum+= count;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        // int[] nums = { 0, 1, 2, 2, 2 };
        int[] nums = { 2, 4, 6, 8, 10 };
        // int[] nums = {7,7,7,7,7 };

        int result = numberOfArithmeticSlices(nums);
        System.out.println(result);
    }
}
