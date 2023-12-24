package matrix;

import java.util.*;

public class Spiral {
    // create matrix mat to list traversing in spiral form
    public static List<Integer> spiral_1(int mat[][]) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = mat.length - 1, left = 0, right = mat[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++)
                result.add(mat[top][j]);
            top++;
            for (int i = top; i <= bottom; i++)
                result.add(mat[i][right]);
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    result.add(mat[bottom][j]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(mat[i][left]);
                left++;
            }
        }
        return result;
    }

    // fill the square matrix of n * n in spiral form from 1 to n^2
    public static int[][] spiral_2(int n) {
        int[][] mat = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int c = 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++)
                mat[top][j] = c++;
            top++;
            for (int i = top; i <= bottom; i++)
                mat[i][right] = c++;
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    mat[bottom][j] = c++;
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    mat[i][left] = c++;
                left++;
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        // int mat[][] = {
        //         { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }
        // };

        // System.out.println(spiral_1(mat));

        int n = 3;
        int spiral [][] = spiral_2(n);
        for(int [] sp : spiral) System.out.println(Arrays.toString(sp));

    }
}
