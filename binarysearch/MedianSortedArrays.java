package binarysearch;

public class MedianSortedArrays {

    public static double linearSearch(int a[], int b[]) {
        int n = (a.length + b.length) / 2;
        // element 2 is at index n in odd array;

        int elem1 = a[0], elem2 = a[0];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length && k <= n) {
            elem1 = elem2;
            if (a[i] > b[j]) {
                elem2 = b[j++];
            } else {
                elem2 = a[i++];
            }
            k++;
        }

        while (i < a.length && k <= n) {
            elem1 = elem2;
            elem2 = a[i++];
            k++;
        }
        while (j < b.length && k <= n) {
            elem1 = elem2;
            elem2 = b[j++];
            k++;
        }

        if ((a.length + b.length) % 2 == 0) {
            return ((double) elem1 + elem2) / 2;
        }

        return elem2;
    }

    public static int bsearch(int a[], int b[]) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            // a[] = { 1, 3, 4, 7, 10, 12 };
            // b[] = { 2, 3, 6, 15 };
            int mid = left + (right - left) / 2;
            if (mid == 0) {

            } else if (mid == a.length - 1) {

            } else {

            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 3, 4, 7, 10, 12 };
        int arr2[] = { 2, 3, 6, 15 };
        // 1, 2, 3, 3, 4, 6, 7, 10, 12, 15

        int arr3[] = { 1, 3, 3, 4 };
        int arr4[] = { 1, 4, 5 };
        // 1, 3, 3, 4, 4

        int arr5[] = { 1, 3 };
        int arr6[] = { 2 };
        // 1, 2, 3

        System.out.println(linearSearch(arr, arr2));
        System.out.println(linearSearch(arr3, arr4));
        System.out.println(linearSearch(arr5, arr6));
 
    }
}
