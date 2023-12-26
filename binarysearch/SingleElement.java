package binarysearch;

public class SingleElement {
    public static int search(int arr[]) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid != 0 && arr[mid] == arr[mid - 1]) {
                if (mid % 2 == 0) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else if (mid != n - 1 && arr[mid] == arr[mid + 1]) {
                if (mid % 2 == 1) {
                    high = mid - 1;
                } else {
                    low = mid + 2;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
        System.out.println(search(arr));
    }
}
