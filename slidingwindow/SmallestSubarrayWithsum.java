package slidingwindow;

//minimal length of a  subarray whose sum is greater than or equal to target.

public class SmallestSubarrayWithsum {
    public static int smallestSubarray(int arr[], int target) {
        int i = 0;
        int j = 0;
        int n = arr.length, sum = 0, min = Integer.MAX_VALUE;

        while (i < n) {
            if (sum >= target) {
                if (sum == target)
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
