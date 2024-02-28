package utilities;

import java.util.Arrays;

public class arrays {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int copy[] = Arrays.copyOf(arr, arr.length + 1);
        // System.out.println(Arrays.toString(copy));
        // System.out.println(Arrays.stream(arr).max().getAsInt());
        // System.out.println(Arrays.stream(copy).min().getAsInt());
        // System.out.println( Arrays.binarySearch(arr, 2));

        // sorting arrays parrallely
        // int[] a = { 4, 2, 4, 8, 2 },
        // b = { 5, 5, 5, 10, 8 },
        // c = { 1,2,8,10,4};
        // int[][] multidim = new int[a.length][3];
        // for (int i = 0; i < multidim.length; i++) {
        // multidim[i][0] = a[i];
        // multidim[i][1] = b[i];
        // multidim[i][2] = c[i];
        // }

        // Arrays.sort(multidim, (as, bs) -> as[0] - bs[0]);
        // for (int dim[] : multidim)
        // System.out.println(Arrays.toString(dim));

        int arr[] = { 1, 3, 5, 7, 8, 9 };
        int index = Arrays.binarySearch(arr, 4);
        System.out.println(index);

    }
}
