package arrays;

import java.util.*;

// For sorted arrays

public class SetOperations {
    public static int[] union(int arr1[], int arr2[]) {
        int arr[] = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {

            int item = 0;
            if (arr1[i] < arr2[j]) {
                item = arr1[i++];
            } else {
                item = arr2[j++];
            }

            if (k == 0 || arr[k - 1] != item) {
                arr[k++] = item;
            }
        }

        while (i < arr1.length) {
            if (k == 0 || arr[k - 1] != arr1[i])
                arr[k++] = arr1[i++];
            else
                i++;
        }
        while (j < arr2.length) {
            if (k == 0 || arr[k - 1] != arr2[j])
                arr[k++] = arr2[j++];
            else
                j++;
        }

        // k = size of arr
        return arr;
    }

    public static int[] intersection(int arr1[], int arr2[]) {
        int arr[] = new int[Math.min(arr1.length, arr2.length)];

        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr1[i] > arr2[j])
                j++;
            else {
                arr[k++] = arr1[i];
                i++;
                j++;
            }
        }

        // k = size of arr
        return arr;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 1, 2, 3, 4, 4, 5 };
        int arr2[] = { 2, 3, 4, 4, 5, 6 };
        System.out.println(Arrays.toString(union(arr1, arr2)));
        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }
}
