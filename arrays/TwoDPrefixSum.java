package arrays;

public class TwoDPrefixSum {
    public static int[][] prefixSum(int matrix[][]) {
        int m = matrix.length, n = matrix[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i + 1][j + 1] = matrix[i][j] + prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j];
            }
        }
        return prefixSum;
    }

    public static int sumOfSubMatrix(int[][] matrix, int row1, int col1, int row2, int col2) {
        int prefixSum[][] = prefixSum(matrix);
        return prefixSum[row2 + 1][col2 + 1] + prefixSum[row1][col1] - prefixSum[row1][col2 + 1]
                - prefixSum[row2 + 1][col1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 }
        };
        System.out.println(sumOfSubMatrix(grid, 1, 1, 2, 2));

    }
}
