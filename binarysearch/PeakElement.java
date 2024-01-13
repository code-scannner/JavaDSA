package binarysearch;

import java.util.*;

public class PeakElement {

    public static int peek(int arr[]) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // for duplicates
            while (mid + 1 < n && arr[mid] == arr[mid + 1])
                mid++;

            if (mid + 1 < n && arr[mid] < arr[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    public static int[] peakElementII(int mat[][]) {
        int m = mat.length, n = mat[0].length;
        int low = 0, high = m - 1;
        int maxidx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int max = Integer.MIN_VALUE;
            maxidx = -1;
            for (int j = 0; j < n; j++) {
                if (mat[mid][j] > max) {
                    max = mat[mid][j];
                    maxidx = j;
                }
            }

            int maxitem = mat[mid][maxidx];

            int top = mid == 0 ? -1 : mat[mid - 1][maxidx];
            int bottom = mid == mat.length - 1 ? -1 : mat[mid + 1][maxidx];

            System.out.printf("mid = %d, maxidx = %d, low = %d, high = %d\n", mid, maxidx, low, high);

            if (maxitem > top && maxitem > bottom)
                return new int[] { mid, maxidx };
            else if (maxitem > top)
                low = mid + 1;
            else
                high = mid - 1;

        }

        return new int[] { low, maxidx };

    }

    public static void main(String[] args) {
        // -------------- 0, 1, 2, 3, 4, 5 ,6, 7, 8, 9
        // int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 2 };
        // int arr2[] = { 1, 2, 3, 4, 5, 6 };
        // int arr3[] = { 6, 5, 4, 3, 2, 1 };
        // int arr4[] = { 1, 2, 2, 2, 3, 5, 4, 3, 2, 2, 1 };

        // System.out.println(peek(arr1));
        // System.out.println(peek(arr2));
        // System.out.println(peek(arr3));
        // System.out.println(peek(arr4));

        // int mat[][] = {
        // { 1, 2, 3, 4, 5, 6, 7, 8 },
        // { 2, 3, 4, 5, 6, 7, 8, 9 },
        // { 3, 4, 5, 6, 7, 8, 9, 10 },
        // { 4, 5, 6, 7, 8, 9, 10, 11 }
        // };
        int mat[][] = {
                { 10, 30, 40, 50, 20 },
                { 1, 3, 2, 500, 4 }
        };

        System.out.println(Arrays.toString(peakElementII(mat)));

    }
}
