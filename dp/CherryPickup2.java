package dp;

import java.util.*;

public class CherryPickup2 {

    // using tabulation space O(n^2);
    public static int cherryPickup(int grid[][]) {
        int m = grid.length, n = grid[0].length;

        int dp[][] = new int[n][n];

        dp[0][n - 1] = n == 0 ? grid[0][0] : grid[0][0] + grid[0][n - 1];

        for (int i = 1; i < m; i++) {
            int curr[][] = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = j; k < n; k++) {

                    // below is O(1) time complexity
                    int max = Integer.MIN_VALUE;
                    for (int p = -1; p <= 1; p++) {
                        for (int q = -1; q <= 1; q++) {
                            int prevj = j + p, prevk = k + q;
                            if (prevj >= 0 && prevk < n && prevj < n && prevk >= 0) {
                                max = Math.max(dp[prevj][prevk], max);
                            }
                        }
                    }

                    curr[j][k] = max + (k == j ? grid[i][j] : grid[i][j] + grid[i][k]);
                }
            }

            dp = curr;
        }

        int max = Integer.MIN_VALUE;
        for (int[] is : dp) {
            max = Math.max(max, Arrays.stream(is).max().getAsInt());
        }
        return max;
    }

    // using dp memorization space O(n^3)
    public static int cherryPickup(int grid[][], int dp[][][], int i, int j1, int j2) {
        if (j1 < 0 || j2 >= grid[0].length)
            return -(int) 1e8;

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;

        if (i == grid.length - 1) {
            max = 0;
        } else {
            for (int k = -1; k <= 1; k++) {
                for (int l = -1; l <= 1; l++) {
                    int newj1 = j1 + k, newj2 = j2 + l;
                    if (newj1 <= newj2) {
                        max = Math.max(max, cherryPickup(grid, i + 1, newj1, newj2));
                    }
                }
            }
        }

        dp[i][j1][j2] = j1 == j2 ? max + grid[i][j1] : max + grid[i][j1] + grid[i][j2];
        return dp[i][j1][j2];
    }

    // using recursion
    public static int cherryPickup(int grid[][], int i, int j1, int j2) {

        if (j1 < 0 || j2 >= grid[0].length)
            return -(int) 1e8;

        int max = Integer.MIN_VALUE;

        if (i == grid.length - 1) {
            max = 0;
        } else {
            for (int k = -1; k <= 1; k++) {
                for (int l = -1; l <= 1; l++) {
                    int newj1 = j1 + k, newj2 = j2 + l;
                    if (newj1 <= newj2) {
                        max = Math.max(max, cherryPickup(grid, i + 1, newj1, newj2));
                    }
                }
            }
        }

        return j1 == j2 ? max + grid[i][j1] : max + grid[i][j1] + grid[i][j2];

    }

    public static void main(String[] args) {
        int grid[][] = {
                { 1, 2, 10, 4 },
                { 1, 3, 2, 1 },
                { 1, 4, 20, 200 },
                { 1, 2, 2, 1 }
        };

        int n = grid[0].length, m = grid.length;

        System.out.println(cherryPickup(grid, 0, 0, n - 1));

        int dp[][][] = new int[m][n][n];
        for (int[][] mat : dp) {
            for (int[] col : mat) {
                Arrays.fill(col, -1);
            }
        }
        System.out.println(cherryPickup(grid, dp, 0, 0, n - 1));
        System.out.println(cherryPickup(grid));

    }
}
