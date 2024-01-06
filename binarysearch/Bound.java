package binarysearch;

public class Bound {

    // smallest index such that arr[i] > target;
    public static int upperBound(int arr[], int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // smallest index such that arr[i] >= target;
    public static int lowerBound(int arr[], int target) {
        int ans = arr.length;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // indexed - 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,12
        int arr[] = { 1, 1, 1, 2, 2, 3, 4, 5, 6, 6, 6, 8, 9 };

        int targets[] = { 6, 7, 0, 10 };
        for (int target : targets) {
            System.out.println("searching " + target);
            System.out.println("lower bound = " + lowerBound(arr, target));
            System.out.println("upper bound = " + upperBound(arr, target));
            System.out.println();
        }
    }
}
