package sorting;

import java.util.Arrays;

public class CountInversions {
    public static int merge(int arr[], int l, int m, int r) {
        int count = 0;

        int arrL[] = Arrays.copyOfRange(arr, l, m + 1);
        int arrR[] = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        while (i < arrL.length && j < arrR.length) {
            if (arrL[i] > arrR[j]) {
                count += arrR.length - j;
                arr[k++] = arrL[i++];
            } else {
                arr[k++] = arrR[j++];
            }
        }
        while (i < arrL.length) {
            arr[k++] = arrL[i++];
        }
        
        while (j < arrR.length) {
            arr[k++] = arrR[j++];
        }

        return count;
    }

    public static int mergeSort(int arr[], int l, int r) {

        if (l < r) {
            int mid = (l + r) / 2;
            int count = mergeSort(arr, l, mid) +
                    mergeSort(arr, mid + 1, r) +
                    merge(arr, l, mid, r);

            return count;

        }

        return 0;
    }

    public static int countPairs(int arr[]) {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 5, 3, 2, 4, 1 };
        System.out.println(countPairs(arr));
        System.out.println(Arrays.toString(arr));
        // System.out.println(merge(arr, 0, 2, 4));

    }
}
