package arrays;
import java.util.*;

public class KandaneAlgo {
    public static int[] maxSubArray(int[] nums) {
        int max = nums[0], sum = 0;
        int i = 0, j = 0;
        for(int k = 0; k<nums.length; k++){
            int num = nums[k];
            if(sum < 0) {
                sum = num;
                i = k;j = k;
            }
            else sum += num;
            if(sum > max){
                max = sum;
                j = k;
            }
        }
        return new int[]{max, i , j};
    }
    public static void main(String[] args) {
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(Arrays.toString(maxSubArray(arr)));
    }
}
