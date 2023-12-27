package dp;

public class UniquePaths {
    // no. of unique paths if can move down and right in matrix
    // reach from 0, 0 to m - 1, n - 1
    public static int uniquePathsMaths(int m, int n) {
        double ans = 1;
        int r = 1;
        for (int i = 1; i < m; i++) {
            ans *= (double) (n++) / (r++);
        }

        return (int) ans;
    }

    public static int uniquePathsObstacles(int grid[][]) {
        int m = grid.length, n = grid[0].length;
        int dp[] = new int[n];
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == -1)
                break;
            dp[j] = 1;
        }
        for (int i = 1; i < m; i++) {
            int curr[] = new int[n];
            curr[0] = dp[0];
            for (int j = 1; j < n; j++) {
                if (grid[i][j] != -1) {
                    curr[j] = curr[j - 1] + dp[j];
                } else {
                    curr[j] = 0;
                }
            }
            dp = curr;
        }
        return dp[n - 1];
    }

    public static int minPathSum(int grid[][]) {
        int m = grid.length, n = grid[0].length;
        int dp[] = new int[n];
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = grid[0][j] + dp[j - 1];
        }
        for (int i = 1; i < m; i++) {
            int curr[] = new int[n];
            curr[0] = grid[i][0] + dp[0];
            for (int j = 1; j < n; j++) {
                curr[j] = grid[i][j] + Math.min(curr[j - 1], dp[j]);
            }
            dp = curr;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsMaths(4, 5));

        int obstacles[][] = {
                { 0, 0, 0 },
                { 0, -1, 0 },
                { 0, 0, 0 }
        };
        System.out.println(uniquePathsObstacles(obstacles));

        int grid[][] = {
                { 10, 8, 2 },
                { 10, 5, 100 },
                { 1, 1, 2 }
        };

        System.out.println(minPathSum(grid));

    }
}
