package binarysearch;

public class BinarySearch{
    public static int binarySearch(int arr[], int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) right = mid - 1;
            else left = mid + 1;
         }
        return -1;
    }
    public static void main(String[] args) {
        int arr []  = {1,1,1,2,2,3,4,5,6,6,6,8,9};
        
        System.out.println(binarySearch(arr, 6));
        System.out.println(binarySearch(arr, 10));
        System.out.println(binarySearch(arr, 0));
    }
}