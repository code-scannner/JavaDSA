package dp;

import java.util.*;

public class TriangleGrid {
    public static int findMinPath(List<List<Integer>> grid) {
        int n = grid.size();
        int dp[] = new int[n];
        dp[0] = grid.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int curr[] = new int[n];
            curr[0] = grid.get(i).get(0) + dp[0];
            for (int j = 1; j < i; j++) {
                curr[j] = grid.get(i).get(j) + Math.min(dp[j - 1], dp[j]);
            }
            curr[i] = grid.get(i).get(i) + dp[i - 1];
            dp = curr;
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp) {
            if (num < min)
                min = num;
        }

        return min;
    }

    public static int usingMemoization(List<List<Integer>> grid, int dp[][], int i, int j) {
        if (dp[i][j] != -1)
            return dp[i][j];
        else if(i == grid.size() - 1)
            dp[i][j] = grid.get(i).get(j);
        else {
            dp[i][j] = grid.get(i).get(j) + Math.min(usingMemoization(grid, dp, i + 1, j), usingMemoization(grid, dp, i + 1, j + 1));
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1));
        grid.add(Arrays.asList(2, 3));
        grid.add(Arrays.asList(3, 6, 7));
        grid.add(Arrays.asList(8, 9, 6, 10));
        // System.out.println(findMinPath(grid));

        int dp[][] = new int[grid.size()][grid.size()];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(usingMemoization(grid, dp, 0, 0));

    }
}
