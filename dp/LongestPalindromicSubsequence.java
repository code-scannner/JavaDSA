package dp;

import java.util.*;

public class LongestPalindromicSubsequence {
    public static int memoization(String str) {
        int n = str.length();
        int dp[][] = new int[n][n];
        for(int is[]: dp) Arrays.fill(is, -1);
        return memo(dp, str, 0, n - 1);
    }

    public static int memo(int dp[][], String str, int l, int r) {
        if (l > r)
            return 0;
        if (l == r)
            return 1;
        if(dp[l][r] != - 1) return dp[l][r];

        if (str.charAt(l) == str.charAt(r))
            dp[l][r] =  2 + memo(dp, str, l + 1, r - 1);
        else {
            dp[l][r] = Math.max(memo(dp, str, l + 1, r), memo(dp, str, l, r - 1));
        }

        return dp[l][r];
    }

    public static void main(String[] args) {
        String str = "bbbab";
        System.out.println(memoization(str));
    }
}
