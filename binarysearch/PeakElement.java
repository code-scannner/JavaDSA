package binarysearch;

public class PeakElement {

    public static int peek(int arr[]) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // for duplicates
            while (mid + 1 < n && arr[mid] == arr[mid + 1])
                mid++;

            if (mid + 1 < n && arr[mid] < arr[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }


    public static int[] peakElementII(int mat[][]) {
        int m = mat.length, n = mat[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int max = Integer.MIN_VALUE;
            int maxidx = -1;
            for (int j = 0; j < n; j++) {
                if(mat[mid][j] > max){
                    max = mat[mid][j];
                    maxidx = j;
                }
            }

            int maxitem = mat[mid][maxidx];


        }

        return new int[]{};

    }

    public static void main(String[] args) {
        // ----------- 0, 1, 2, 3, 4, 5 ,6, 7, 8, 9
        // int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 2 };
        // int arr2[] = { 1, 2, 3, 4, 5, 6 };
        // int arr3[] = { 6, 5, 4, 3, 2, 1 };
        // int arr4[] = { 1, 2, 2, 2, 3, 5, 4, 3, 2, 2, 1 };

        // System.out.println(peek(arr1));
        // System.out.println(peek(arr2));
        // System.out.println(peek(arr3));
        // System.out.println(peek(arr4));

        int mat[][] = {
                { 4, 2, 5, 1, 4, 5 },
                { 2, 9, 3, 2, 3, 2 },
                { 1, 7, 6, 0, 1, 3 },
                { 3, 6, 2, 3, 7, 2 }
        };

        System.out.println(peakElementII(mat));

    }
}
