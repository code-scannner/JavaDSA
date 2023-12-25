package matrix;

public class Determinant {
    public static int determinant(int matrix[][], int n, boolean col[], int i) {
        if (i >= n) {
            return 1;
        }
        int sign = 1;
        int result = 0;
        for (int j = 0; j < n; j++) {
            if (!col[j]) {
                col[j] = true;
                result += matrix[i][j] * sign * determinant(matrix, n, col, i + 1);
                sign *= -1;
                col[j] = false;
            }

        }
        return result;
    }

    public static int findDeterminant(int mat[][]) {
        int n = mat.length;
        boolean col[] = new boolean[n];
        return determinant(mat, n, col, 0);
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 2, -1 },
                { 3, 0, 0, 5 },
                { 2, 1, 4, -3 },
                { 1, 0, 5, 0 } };
        System.out.println(findDeterminant(matrix));
    }
}
