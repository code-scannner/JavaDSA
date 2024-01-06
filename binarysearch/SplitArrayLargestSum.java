package binarysearch;

public class SplitArrayLargestSum {
    public static int partitions(int arr[], int max) {
        int i = 0, p = 1, sum = 0;

        while (i < arr.length) {
            if (arr[i] + sum > max) {
                p++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            i++;
        }

        return p;
    }

    public static int largestSum(int arr[], int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int elem : arr) {
            if (elem > max)
                max = elem;
            sum += elem;
        }

        int left = max;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int ans = partitions(arr, mid);
            if (ans > k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40 };
        System.out.println(largestSum(arr, 2));
    }
}
