package arrays;

import java.util.*;

public class Rotate {
    public static void reverse(int arr[], int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void leftRotate(int arr[], int rotate) {
        // 1 2 3 4 5 6 7
        // left rotate by 3
        // 4 5 6 7 1 2 3
        int n = arr.length;
        reverse(arr, 0, rotate - 1);
        reverse(arr, rotate, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void rightRotate(int arr[], int rotate) {
        // 1 2 3 4 5 6 7
        // right rotate by 3
        // 5 6 7 1 2 3 4
        int n = arr.length;
        reverse(arr, 0, n - rotate - 1);
        reverse(arr, n - rotate, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        leftRotate(arr, 3);
        System.out.println(Arrays.toString(arr));
        rightRotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
