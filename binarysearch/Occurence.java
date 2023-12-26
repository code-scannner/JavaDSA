package binarysearch;

public class Occurence {
    public static int firstOccurence(int arr[], int target) {

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                if (mid == 0 || arr[mid - 1] != target)
                    return mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
    public static int lastOccurence(int arr[], int target) {

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                if (mid == arr.length - 1 || arr[mid + 1] != target)
                    return mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // indexed - 0, 1, 2, 3, 4, 5, 6, 7
        int arr[] = { 2, 4, 6, 8, 8, 8, 11, 13 };

        int targets[] = { 8, 11, 0, 14, 13 };

        for (int target : targets) {
            // System.out.println(firstOccurence(arr, target));
            System.out.println(lastOccurence(arr, target));
        }
    }
}
