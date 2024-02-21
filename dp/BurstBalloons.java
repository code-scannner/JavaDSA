package dp;

import java.util.*;

public class BurstBalloons {
    public static int recursion(List<Integer> balloons, int i, int j) {
        if (i > j)
            return 0;
        if (i == j) {
            if (i == 0 || i == balloons.size() - 1)
                return 0;
            return balloons.get(i) * balloons.get(i - 1) * balloons.get(i + 1);
        }

        int max = 0;
        for (int k = i; k <= j; k++) {
            max = Math.max(max,
                    balloons.get(i - 1) * balloons.get(j + 1) * balloons.get(k) + recursion(balloons, i, k - 1)
                            + recursion(balloons, k + 1, j));
        }

        return max;
    }

    public static int memo(int dp[][], List<Integer> balloons, int i, int j) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i == j) {
            if (i == 0 || i == balloons.size() - 1)
                dp[i][j] = 0;
            else
                dp[i][j] = balloons.get(i) * balloons.get(i - 1) * balloons.get(i + 1);
            return dp[i][j];
        }

        int max = 0;
        for (int k = i; k <= j; k++) {
            max = Math.max(max,
                    balloons.get(i - 1) * balloons.get(j + 1) * balloons.get(k) + recursion(balloons, i, k - 1)
                            + recursion(balloons, k + 1, j));
        }
        dp[i][j] = max;
        return max;
    }

    public static int memoization(List<Integer> balloons) {
        int n = balloons.size();
        int dp[][] = new int[n][n];
        for (int arr[] : dp)
            Arrays.fill(arr, -1);
        return memo(dp, balloons, 1, balloons.size() - 2);
    }

    public static int tabulation(List<Integer> balloons) {
        int n = balloons.size();
        int dp[][] = new int[n][n];
        for (int i = n - 2; i > 0; i--) {
            for (int j = i; j < n - 1; j++) {
                int max = 0;
                for (int k = i; k <= j; k++) {
                    max = Math.max(max,
                            balloons.get(i - 1) * balloons.get(j + 1) * balloons.get(k) + dp[i][k - 1] + dp[k + 1][j]);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n - 2];
    }

    public static void main(String[] args) {
        int balloons[] = { 3, 1, 5, 8 };
        List<Integer> b = new ArrayList<>();
        b.add(1);
        for (int bal : balloons)
            b.add(bal);
        b.add(1);
        System.out.println(recursion(b, 1, b.size() - 2));
        System.out.println(memoization(b));
        System.out.println(tabulation(b));
    }
}
