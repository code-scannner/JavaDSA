package sorting;

import java.util.*;

public class MergeSortedArrays {
    public static void swap(int arr1[], int arr2[], int a, int b) {
        int temp = arr1[a];
        arr1[a] = arr2[b];
        arr2[b] = temp;
    }

    public static void usingShellSort(int arr1[], int arr2[]) {
        int m = arr1.length;
        int n = arr2.length;
        double gap = Math.ceil((m + n) / 2.0) * 2;
        while (gap != 1) {
            gap = Math.ceil(gap / 2);
            int left = 0, right = (int) gap;
            while (right < m + n) {
                if (right < m) {
                    if (arr1[left] > arr1[right]) {
                        swap(arr1, arr1, left, right);
                    }
                } else if (left < m && right >= m) {
                    if (arr1[left] > arr2[right - m]) {
                        swap(arr1, arr2, left, right - m);
                    }
                }
                // left >= m && right >= m
                else {
                    if (arr2[left - m] > arr2[right - m]) {
                        swap(arr2, arr2, left - m, right - m);
                    }
                }
                left++;
                right++;
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 3, 5, 7, 10, 12 };
        int arr2[] = { 0, 2, 4, 6, 8, 9, 11 };
        usingShellSort(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }
}
