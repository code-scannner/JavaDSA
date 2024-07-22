package codechef;

import java.util.*;

public class Codechef {
    static int MAX = (int) 1e9 + 7;

    public static int solve(int a, int b, int c, int d, int e, int f, int n) {
        int mat[][] = {
                { a, 0, 0, 0, b, 0 },
                { 0, c, 0, 0, 0, d },
                { 1, 0, e, f, 0, 0 },
                { 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0 }
        };
        int pow[][] = matPow(mat, n - 1, MAX);
        long ans = 0;
        for (int i = 0; i < 6; i++) {
            ans = ans + pow[0][i];
        }

        return (int) (ans % MAX);

    }

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
        System.out.println(solve(5, 6, 3, 7, 1, 2, 5));
    }
}