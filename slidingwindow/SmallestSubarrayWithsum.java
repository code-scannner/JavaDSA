package slidingwindow;

public class SmallestSubarrayWithsum {
    public static int smallestSubarray(int arr[], int k) {
        int i = 0;
        int j = 0;
        int n = arr.length, sum = 0, min = Integer.MAX_VALUE;

        while (i < n) {
            if (sum >= k) {
                if (sum == k)
                    min = Math.min(min, j - i);
                sum -= arr[i++];
            } else {
                if (j == n)
                    break;
                sum += arr[j++];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 2, 7, 1, 1, 2, 5, 1, 0 };
        System.out.println(smallestSubarray(arr, 8));
    }
}
