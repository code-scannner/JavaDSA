package leetcode;

import java.math.BigInteger;
import java.util.*;

public class leet_2801 {
    public static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        String low = "2", r = "40";
        // 1 , 2, 3, ... 9, 10, 12, 21,23, 32, 34
        BigInteger l = new BigInteger(low);
        l = l.subtract(new BigInteger("1"));

        int result = (memo(r) - memo(l.toString()) + mod) % mod;
        System.out.println(result);
    }

    public static int memo(String n) {

        int dp[][][][] = new int[n.length()][2][2][10];
        for (int mat[][][] : dp) {
            for (int arr[][] : mat) {
                for (int a[] : arr) {
                    Arrays.fill(a, -1);
                }
            }
        }

        return memo(dp, 0, 1, 0, 0, n);
    }

    public static int memo(int[][][][] dp, int i, int tight, int start, int prev, String n) {
        if (i == n.length())
            return 1;

        if (dp[i][tight][start][prev] != -1)
            return dp[i][tight][start][prev];

        int end = tight == 1 ? (n.charAt(i) - '0') : 9;

        long cnt = 0;

        if (start == 0) {
            cnt += memo(dp, i + 1, 0, 0, prev, n);
            for (int j = 1; j <= end; j++) {
                cnt += memo(dp, i + 1, (tight == 1 && j == end) ? 1 : 0, 1, j, n);
            }
        } else {
            int left = prev - 1, right = prev + 1;
            if (left >= 0 && left <= end) {
                cnt += memo(dp, i + 1, (tight == 1 && left == end) ? 1 : 0, 1, left, n);
            }
            if (right <= end) {
                cnt += memo(dp, i + 1, (tight == 1 && right == end) ? 1 : 0, 1, right, n);
            }
        }

        cnt %= mod;

        dp[i][tight][start][prev] = (int) (cnt);

        return (int) (cnt);
    }
}
