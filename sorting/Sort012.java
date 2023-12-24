package sorting;
import java.util.*;

// Dutch National Flag Algorithm
public class Sort012 {
    public static void swap(int [] arr, int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort012(int[] arr)
    {
        int low = 0, mid = 0, high = arr.length - 1;
        while(mid <= high){
            int val = arr[mid];
            if(val == 0){
                swap(arr, low++, mid++);
            }
            else if(val == 1){
                mid++;
            }
            else {
                swap(arr, mid, high--);
            }
        }
    }
    public static void main(String[] args) {
        int arr [] = {0, 1, 2, 2, 1, 0};
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }
}
