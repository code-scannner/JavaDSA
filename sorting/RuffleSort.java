package sorting;

import java.util.*;

// faster sorting in CP

public class RuffleSort {
    public static void shuffle(int arr[]) {
        Random r = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int idx = r.nextInt(n);
            if (idx != i) {
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 6, 2, 4, 5, 1, 3, 4, 8, 7, 9, 8, 5, 3, 4, 5, 6, 2, 3 };
        shuffle(arr);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
