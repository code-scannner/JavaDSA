package slidingwindow;

public class CountSubarraySum {
    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 0, 1 };
        System.out.println(subarraySumEqualToK(arr, 2));
    }

    public static int subarraySumEqualToK(int arr[], int k) {
        return subarraySumLessThanK(arr, k)  - subarraySumLessThanK(arr, k - 1);
    }

    public static int subarraySumLessThanK(int arr[], int k) {
        if (k < 0)
            return 0;
        int i = 0, j = 0, sum = 0, n = arr.length, cnt = 0;
        while (i < n) {
            sum += arr[i];
            while (sum > k && j <= i) {
                sum -= arr[j++];
            }
            cnt += i - j + 1;
            i++;
        }
        return cnt;
    }
}
