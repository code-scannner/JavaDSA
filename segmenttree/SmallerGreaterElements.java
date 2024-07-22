package segmenttree;

import java.util.*;

public class SmallerGreaterElements {
    /**
     * @param right if searching for right elements set true, else false
     * @param equal if searching for elements (greater equal/ smaller equal) to
     *              itself set true, else false
     * @return a indexed version of array for searching in binary indexed tree
     */
    public static int[] indexSort(int arr[], boolean right, boolean equal) {

        // formula for relative Ordering true or not when we deal with duplicate
        // elements
        boolean relativeOrdering = right ^ equal;

        int n = arr.length;
        int index[][] = new int[n][2];
        for (int i = 0; i < n; i++)
            index[i] = new int[] { arr[i], i };

        Arrays.sort(index, (a, b) -> a[0] == b[0] ? relativeOrdering ? (a[1] - b[1]) : (b[1] - a[1]) : a[0] - b[0]);

        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[index[i][1]] = i + 1;
        }
        return res;
    }

    public static int[] smallerRight(int arr[], boolean equal) {
        int n = arr.length;
        int index[] = indexSort(arr, true, equal);
        BinaryIndexedTree bit = new BinaryIndexedTree(n + 1);
        int res[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            bit.add(index[i], 1);
            res[i] = bit.sum(index[i] - 1);
        }
        return res;
    }

    public static int[] smallerLeft(int arr[], boolean equal) {
        int n = arr.length;
        int index[] = indexSort(arr, false, equal);
        BinaryIndexedTree bit = new BinaryIndexedTree(n + 1);
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            bit.add(index[i], 1);
            res[i] = bit.sum(index[i] - 1);
        }
        return res;
    }

    public static int[] greaterLeft(int arr[], boolean equal) {
        int[] res = smallerLeft(arr, !equal);
        for (int i = 0; i < arr.length; i++) {
            res[i] = i - res[i];
        }
        return res;
    }

    public static int[] greaterRight(int arr[], boolean equal) {
        int[] res = smallerRight(arr, !equal);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            res[i] = n - i - 1 - res[i];
        }
        return res;
    }

    public static void main(String[] args) {

        // task is to calculate number of smaller elements to right of it in the arr;
        int arr[] = { 12, 34, 5, 33, 67, 8, 33, 4, 33, 33 };
        System.out.println(Arrays.toString(smallerRight(arr, true)));
        System.out.println(Arrays.toString(smallerRight(arr, false)));
        System.out.println(Arrays.toString(smallerLeft(arr, true)));
        System.out.println(Arrays.toString(smallerLeft(arr, false)));
        System.out.println();
        System.out.println(Arrays.toString(greaterRight(arr, true)));
        System.out.println(Arrays.toString(greaterRight(arr, false)));
        System.out.println(Arrays.toString(greaterLeft(arr, true)));
        System.out.println(Arrays.toString(greaterLeft(arr, false)));

    }
}
