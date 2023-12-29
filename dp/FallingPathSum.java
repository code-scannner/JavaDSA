package dp;

import java.util.Arrays;

public class FallingPathSum {
    public static int maxSum(int grid[][]) {
        int m = grid.length, n = grid[0].length;
        int dp [] = Arrays.copyOf(grid[0], n);
        for (int i = 1; i < m; i++) {
            int curr[] = new int[n];
            curr[0] = grid[i][0] + Math.max(dp[0], dp[1]);
            for (int j = 1; j < n - 1; j++) {
                curr[j] = grid[i][j] + Math.max(dp[j], Math.max(dp[j - 1], dp[j + 1]));
            }
            curr[n - 1] = grid[i][n - 1] + Math.max(dp[n - 1], dp[n - 2]);
            dp = curr;
        }
        
        return Arrays.stream(dp).max().getAsInt();
        
    }
    public static void main(String[] args) {
        int grid [][] = {
            {1,2,10,4},
            {100,3,2,1},
            {1,1,20,2},
            {1,2,2,1}
        };
        System.out.println(maxSum(grid));
    }
}