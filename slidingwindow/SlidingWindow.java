package slidingwindow;
import java.util.*;

public class SlidingWindow {
    public static int[] sliding_sum(int arr[], int window) {
        int n = arr.length;
        if(n < window) return null;
        int res[] = new int[n - window + 1]; // result size
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // adding to end of window
            sum += arr[i];
            if (i >= window) {
                // removing from front of window
                sum -= arr[i - window];
            }
            if (i >= window - 1) {
                // adding to the result
                res[i - window + 1] = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 6, 63, 3 };
        int window_size = 3;
        int result[] = sliding_sum(arr, window_size);
        System.out.println(Arrays.toString(result));
    }
}
