package matrix;

import java.util.*;

public class DiagonalTraverse {

    public static int[] diagonalTraverse(int[][] matrix) {
        int n = matrix[0].length;
        int[] ans = new int[n * n];
        int k = 0, i = 0, j = 0, si = 0, sj = 0;
        while (k < ans.length) {
            ans[k++] = matrix[i][j];
            if (j == 0 || i == n - 1) {
                if (sj == n - 1)
                    si++;
                else
                    sj++;
                i = si;
                j = sj;
            } else {
                i++;
                j--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] mat = {
                { 1, 2, 3, },
                { 5, 6, 7, },
                { 9, 10, 11, }
        };
        System.out.println(Arrays.toString(diagonalTraverse(mat)));
    }
}
