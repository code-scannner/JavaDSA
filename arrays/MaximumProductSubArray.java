package arrays;

public class MaximumProductSubArray {
    public static long maximumProduct(int arr[]) {
        long prefix = 0, suffix = 0, max = Long.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i<n; i++) {

            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix *= arr[i];
            suffix *= arr[n - i - 1];
            
            max = Math.max(max, Math.max(prefix, suffix));
        }
        
        return max;
    }

    public static void main(String[] args) {
        // int arr[] = { 2, 3, -2, 4 };
        int arr[] = { 2, -2, 4, 6, -1, 0, 3, 3, 8 };
        System.out.println(maximumProduct(arr));

    }
}
