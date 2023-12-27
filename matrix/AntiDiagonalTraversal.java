package matrix;

import java.util.*;

public class AntiDiagonalTraversal {
    // mat is a square matrix
    public static int[] antiDiagonal(int[][] matrix) {
        int n = matrix.length;
        int[] ans = new int[n * n];
        int k = 0, i = 0, j = 0;
        while (k < ans.length) {
            ans[k++] = matrix[i][j];
            System.out.printf("i = %d, j = %d\n", i , j);
            if ((i + j) % 2 == 0) {
                if (j == n - 1)
                    i++;
                else if (i == 0)
                    j++;
                else {
                    i--;
                    j++;
                }
            } else {
                if (i == n - 1)
                    j++;
                else if (j == 0)
                    i++;
                else {
                    i++;
                    j--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(Arrays.toString(antiDiagonal(mat)));
    }
}
