package binarysearch;

import java.util.*;

public class KthMissingPositive {
    public static int kthMissing(int arr[], int k) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missingLeft = arr[mid] - mid - 1;
            if (missingLeft >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left + k;

    }

    public static void main(String[] args) {

        // arr be like :- 1(1), 2, 3, 4, 5(2), 6(3), 7, 8(4), 9(5), 10(6), 11
        int arr[] = { 1, 2, 3, 4, 7, 11 };
        System.out.println(kthMissing(arr, 1));
        System.out.println(kthMissing(arr, 0));
        System.out.println(kthMissing(arr, 7));
        System.out.println(kthMissing(arr, 6));
    }
}
