package maths;

import java.util.*;

public class GeneratePermutations {
    public static void generate(int arr[]) {
        generate(arr, 0);
    }

    public static void generate(int arr[], int i) {
        if (i == arr.length - 1) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int j = i; j < arr.length; j++) {
                swap(arr, i, j);
                generate(arr, i + 1);
                swap(arr, i, j);
            }
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        generate(arr);
    }
}
