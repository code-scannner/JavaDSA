package leetcode;

public class leet_100181 {
    public static int minimumCost(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }

        return nums[0] + min1 + min2;
    }

    public static void main(String[] args) {
        // int arr[] = { 10, 3, 1, 1 };
        int arr[] = { 1, 1, 1, 2, 3, 4, 5 };
        System.out.println(minimumCost(arr));
    }
}
