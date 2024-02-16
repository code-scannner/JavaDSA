package sorting;

import java.util.*;

public class Sorts {
    public static void merge(int nums[], int l, int m, int r) {
        int ln = m - l + 1;
        int rn = r - m;
        int left[] = new int[ln];
        int right[] = new int[rn];
        for (int i = 0; i < ln; i++)
            left[i] = nums[l + i];
        for (int i = 0; i < rn; i++)
            right[i] = nums[m + 1 + i];
        int i = 0, j = 0, k = l;
        while (i < ln && j < rn) {
            if (left[i] <= right[j])
                nums[k++] = left[i++];
            else
                nums[k++] = right[j++];
        }
        while (i < ln)
            nums[k++] = left[i++];
        while (j < rn)
            nums[k++] = right[j++];
    }

    public static void mergeSort(int nums[], int i, int j) {
        if (i < j) {
            int mid = i + (j - i) / 2;
            mergeSort(nums, i, mid);
            mergeSort(nums, mid + 1, j);
            merge(nums, i, mid, j);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 8, 4, 6, 2, 4, 3, 7, 8, 5, 4 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
