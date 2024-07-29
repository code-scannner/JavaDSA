package leetcode;

import java.util.*;

public class leet_902 {
    public static void main(String[] args) {
        String digits[] = { "1", "3", "5", "7" };
        int n = 100;
        long result = memo(n, digits);
        System.out.println(result);
    }

    public static long memo(int n, String digits[]) {
        boolean map[] = new boolean[10];
        for (int i = 0; i < digits.length; i++) {
            map[digits[i].charAt(0) - '0'] = true;
        }
        long dp[][][] = new long[10][2][2];
        for (long mat[][] : dp) {
            for (long arr[] : mat) {
                Arrays.fill(arr, -1);
            }
        }

        return memo(dp, 0, 1, 0, map, Integer.toString(n)) - 1;
    }

    public static long memo(long[][][] dp, int i, int tight, int start, boolean map[], String n) {
        if (i == n.length())
            return 1;

        if (dp[i][tight][start] != -1)
            return dp[i][tight][start];

        int end = tight == 1 ? (n.charAt(i) - '0') : 9;

        int cnt = 0;

        if (start == 0) {
            cnt += memo(dp, i + 1, 0, 0, map, n);
        }

        for (int j = 1; j <= end; j++) {
            if (map[j]) {
                cnt += memo(dp, i + 1, (tight == 1 && j == end) ? 1 : 0, 1, map, n);
            }
        }

        dp[i][tight][start] = cnt;

        return cnt;
    }
}
