package arrays;

import java.util.*;

public class MaxSubarraySumK {
    // used for 0s and positive values
    public static int non_negatives(int arr[], int k) {
        int max = 0;
        int i = 0, j = 0;
        long sum = 0;
        while (j < arr.length || i < arr.length) {
            if (sum > k) {
                sum -= arr[i++];
            } else {
                if (j == arr.length)
                    break;
                sum += arr[j++];
            }
            if (sum == k) {
                max = Math.max(max, j - i);
            }
        }
        return max;
    }

    // used for all integers
    public static int all(int [] arr, int k) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        int max = 0;
        long sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum+=arr[i];
            if(map.get(sum - k) != null){
                int idx = map.get(sum- k);
                max = Math.max(max, i - idx);
            }
            
            map.putIfAbsent(sum, i);
        }
        return max;
        
    }

    public static void main(String[] args) {
        // int arr[] = { 8, 15, 17, 0, 11 };
        int arr[] = { -10, 8, 2, -2};
        // int arr[] = { -1,1,1};
        int k = -2;
        // System.out.println(non_negatives(arr, k));
        System.out.println(all(arr, k));

    }
}
