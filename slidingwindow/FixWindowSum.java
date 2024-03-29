package slidingwindow;

import java.util.*;

public class FixWindowSum {

    public static int fixWindowMax(int arr[], int k) {
        int n = arr.length, sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                if (i - k >= 0) {
                    sum -= arr[i - k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static int fixWindowMin(int arr[], int k) {
        int n = arr.length, sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                if (i - k >= 0)
                    sum -= arr[i - k];
                min = Math.min(min, sum);
            }
        }
        return min;
    }

    public static int[] fixSizeSum(int arr[], int k) {
        int n = arr.length, sum = 0;
        int result[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i >= k) {
                result[i] = sum;
                sum -= arr[i - k];
            }
            if (i < n)
                sum += arr[i];
        }
        return result;
    }

    public static int[] fixSizeMax(int arr[], int k) {
        int n = arr.length, sum = 0;
        int result[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i >= k) {
                result[i] = sum;
                result[i] = Math.max(result[i], result[i - 1]);
                sum -= arr[i - k];
            }
            if (i < n)
                sum += arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 8, 1, 3, 2, 1, 8, 9, 0 };
        int size = 3;
        System.out.println(Arrays.toString(fixSizeSum(arr, size)));
        System.out.println(Arrays.toString(fixSizeMax(arr, size)));
        System.out.println(fixWindowMax(arr, size));
        System.out.println(fixWindowMin(arr, size));

    }
}
