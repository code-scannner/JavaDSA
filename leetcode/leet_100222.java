package leetcode;

import java.util.*;

public class leet_100222 {
    public String triangleType(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        if (((nums[0] + nums[1]) > nums[2]) && ((nums[1] + nums[2]) > nums[0]) && ((nums[0] + nums[2]) > nums[1])) {
            for (int i = 0; i < nums.length; i++) {
                mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);

            }

            if (mp.values().contains(3))
                return "equilateral";
            if (mp.values().contains(2))
                return "isosceles";

            return "scalene";
        }
        return "none";
    }

    public static void main(String[] args) {

    }
}
