package binarysearch;

public class MedianInSortedMatrix {
    public static int get(int low, int high, int[][] matrix, int leftNums) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int ans = 0;
            for (int i = 0; i < matrix.length; i++) {
                ans += Bound.upperBound(matrix[i], mid);
            }

            if (ans <= leftNums) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return low;
    }

    public static double median(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int high = Integer.MIN_VALUE, low = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            high = Math.max(high, matrix[i][n - 1]);
            low = Math.min(low, matrix[i][0]);
        }

        if (m * n % 2 == 0) {
            return ((double) get(low, high, matrix, (m * n - 1) / 2) + get(low, high, matrix, m * n / 2)) / 2.0;
        } else {
            return (double) get(low, high, matrix, (m * n / 2));
        }

    }

    public static void main(String[] args) {
        int matrix[][] = new int[][] {
                { 1, 5, 7, 9, 9, 10, 11 },
                { 2, 3, 4, 5, 10, 12, 14 }
        };
        System.out.println(median(matrix));
    }
}
