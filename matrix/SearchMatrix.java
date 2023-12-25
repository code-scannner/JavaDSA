package matrix;

import java.util.*;

public class SearchMatrix {
    public static int[] binarySearch(int mat[][], int target) {
        int m = mat.length;
        int n = mat[0].length;
        int left = 0, right = m * n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int i = mid / n;
            int j = mid % n;
            if (mat[i][j] == target)
                return new int[] { i, j };
            else if (mat[i][j] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return new int[] { -1 };
    }

    public static int[] binarySearchII(int mat[][], int target) {
        int m = mat.length, n = mat[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if(mat[row][col] == target) return new int[]{row,col};
            else if(mat[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }


        return new int[]{-1};
    }

    public static void main(String[] args) {
        // int mat[][] = {
        //         { 3, 4, 7, 9 },
        //         { 12, 13, 16, 18 },
        //         { 20, 21, 23, 29 }
        // };

        int mat2[][] = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };

        int targets [] = {23,9,3,14,30};
        for (int target : targets) {
            // System.out.println(Arrays.toString(binarySearch(mat,target)));
            System.out.println(Arrays.toString(binarySearchII(mat2,target)));

        }
        
    }
}
