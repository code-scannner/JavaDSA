package leetcode;

import java.util.*;

/**
 * leet_bit_dp
 */
public class leet_bit_dp {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("for i = " + i + ", ans = " + memo(i));
        }
    }

    public static int memo(int n) {
        if (n == 0)
            return 1;
        int len = (int) (Math.log(n) / Math.log(2)) + 1;
        int dp[][][] = new int[len][2][2];
        for (int mat[][] : dp) {
            for (int arr[] : mat) {
                Arrays.fill(arr, -1);
            }
        }
        // System.out.println("len = "+ len);
        return memo(dp, 0, 1, 0, len, n);
    }

    public static int memo(int dp[][][], int i, int tight, int prev, int len, int n) {
        if (i == len)
            return 1;

        if (dp[i][tight][prev] != -1)
            return dp[i][tight][prev];

        int ithBit = (n & (1 << (len - i - 1))) == 0 ? 0 : 1;

        // placing a 0
        int cnt = memo(dp, i + 1, (tight == 1 && ithBit == 0) ? 1 : 0, 0, len, n);

        // placing a 1
        if ((tight == 0 || ithBit == 1) && prev != 1) {
            cnt += memo(dp, i + 1, (tight == 1 && ithBit == 1) ? 1 : 0, 1, len, n);
        }
        
        dp[i][tight][prev] = cnt;
        return cnt;

    }
}