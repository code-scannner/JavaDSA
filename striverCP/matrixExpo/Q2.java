package striverCP.matrixExpo;

import java.util.*;

public class Q2 {
    static int mod = (int) 1e9 + 7;

    // printMatrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // given that both are square matrix of order n
    // Time Complexity O(n^3)
    public static int[][] multiply(int[][] mat1, int[][] mat2, int mod) {
        int n = mat1.length;
        int res[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long val = 0;
                for (int k = 0; k < n; k++) {
                    val += ((long) mat1[i][k] * mat2[k][j]) % mod;
                }
                res[i][j] = (int) (val % mod);
            }
        }
        return res;
    }

    public static int[][] matPow(int[][] mat, long p, int range) {
        if (p == 0) {
            int n = mat.length;
            int base[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                base[i][i] = 1;
            }
            return base;
        }
        if (p == 1)
            return mat;
        int res[][] = matPow(mat, p / 2, range);
        int ans[][] = multiply(res, res, range);
        if (p % 2 == 1) {
            return multiply(ans, mat, range);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();
        int[][] mat = new int[m][m];
        mat[0][0] = 1; mat[0][m - 1] = 1;
        for(int i = 1; i<m; i++){
            mat[i][i - 1] = 1;
        }
        System.out.println(matPow(mat, n - m + 2, mod)[0][0]);
        sc.close();
    }
}
