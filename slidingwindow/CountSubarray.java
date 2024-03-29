package slidingwindow;

public class CountSubarray {
    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 0, 1 };
        System.out.println(countSubarraySumEqualToK(arr, 2));
        System.out.println(countSubarraySumGreaterThanK(arr, 2));
        System.out.println(countSubarraySumLessThanEqualToK(arr, 2));
    }

    public static int countSubarraySumEqualToK(int arr[], int k) {
        return countSubarraySumLessThanEqualToK(arr, k) - countSubarraySumLessThanEqualToK(arr, k - 1);
    }

    public static long countSubarraySumGreaterThanK(int arr[], int k) {
        int n = arr.length;
        return (long) n * (n + 1) / 2 - countSubarraySumLessThanEqualToK(arr, k - 1);
    }

    public static int countSubarraySumLessThanEqualToK(int arr[], int k) {
        if (k < 0)
            return 0;
        int j = 0, sum = 0, n = arr.length, cnt = 0;
        for (int i = 0; i<n; i++) {
            sum += arr[i];
            while (sum > k && j <= i) {
                sum -= arr[j++];
            }
            cnt += i - j + 1;
        }
        return cnt;
    }

}
