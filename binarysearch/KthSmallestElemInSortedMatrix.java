package binarysearch;

public class KthSmallestElemInSortedMatrix {
    public static int kthSmallest(int matrix[][], int k) {
        int left = matrix[0][0],
                right = matrix[matrix.length - 1][matrix[0].length - 1];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int ans = 0;
            for (int i = 0; i < matrix.length; i++) {
                ans += Bound.upperBound(matrix[i], mid);
            }
            if (ans >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 }
        };
        System.out.println(kthSmallest(matrix, 1));
    }
}
