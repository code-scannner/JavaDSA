package arrays;

public class Operations {
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
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        reverse(arr, 0, arr.length - 1);
        System.out.println(arr);
    }
}
