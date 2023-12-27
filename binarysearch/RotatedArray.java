package binarysearch;

public class RotatedArray {
    public static boolean search_duplicates(int arr[], int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return true;
            // for duplicates trimming down the search space by 1 both sides;
            else if (arr[mid] == arr[low] && arr[mid] == arr[high]) {
                low++;
                high--;
            } else if (arr[mid] >= arr[low]) {
                // left half sorted
                // target in left half
                if (arr[low] <= target && target <= arr[mid])
                    high = mid - 1;
                // target in right half
                else
                    low = mid + 1;
            } else {
                // right half sorted
                // target in right half
                if (arr[mid] <= target && target <= arr[high])
                    low = mid + 1;
                // target in left half
                else
                    high = mid - 1;
            }

        }

        return false;
    }

    public static int search(int arr[], int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;

            else if (arr[mid] >= arr[low]) { // TOOD: why the greater symbol causes error on removing
                // left half sorted
                // target in left half
                if (arr[low] <= target && target <= arr[mid])
                    high = mid - 1;
                // target in right half
                else
                    low = mid + 1;
            } else {
                // right half sorted
                // target in right half
                if (arr[mid] <= target && target <= arr[high])
                    low = mid + 1;
                // target in left half
                else
                    high = mid - 1;
            }

        }

        return -1;
    }

    public static int min(int arr[]) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int min = Integer.MAX_VALUE, minidx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // as minimum is first element in sorted array;
            if (arr[low] <= arr[high])
                return low;

            // for duplicates in the array trim down the array from both sides;
            else if (arr[mid] == arr[high] && arr[mid] == arr[low]) {
                if (min > arr[mid]) {
                    min = Math.min(min, arr[mid]);
                    minidx = mid;
                }
                low++;
                high--;
            } else if (arr[mid] >= arr[low]) {
                // left half sorted
                if (min > arr[low]) {
                    min = Math.min(min, arr[low]);
                    minidx = low;
                }
                low = mid + 1;
            } else {
                // right half sorted
                if (min > arr[mid]) {
                    min = Math.min(min, arr[mid]);
                    minidx = mid;
                }
                high = mid - 1;
            }
        }

        return minidx;
    }

    public static void main(String[] args) {
        // ---------- 1, 2, 3, 4, 5, 6, 7, 8, 9
        int arr[] = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        // int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        // int arr[] = { 3, 3, 1, 2, 3, 3, 3, 3, 3 };

        // System.out.println(search(arr, 1));
        // System.out.println(search_duplicates(arr, 2));
        System.out.println("min elem = " + arr[min(arr)]);
        System.out.println("right rotations = " + min(arr));
        System.out.println("left rotations = " + (arr.length - min(arr)));
    }
}
