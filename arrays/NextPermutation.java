package arrays;
import java.util.*;

public class NextPermutation {
    public static void swap(int arr[], int l , int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    public static void reverse(int arr[], int l , int r) {
        while(l < r){
            swap(arr, l++, r--);
        }
    }
    public static void next_permutation(int arr[]) {
        int n = arr.length;
        int i = n - 2;
        while(i >= 0 && arr[i] >= arr[i + 1]) i--;

        if(i < 0) {
            reverse(arr, 0, n - 1);
            return;
        }

        int j = i + 1;
        while(j < n && arr[i] < arr[j]) j++;
        swap(arr, j - 1, i);
        reverse(arr, i + 1, n - 1);
        
    }
    public static void main(String[] args) {
        // int arr [] = {2,1,5,4,3,0,0};
        int arr [] = {5,4,3,2,1};
        next_permutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
