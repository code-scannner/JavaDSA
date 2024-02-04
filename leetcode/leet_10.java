package leetcode;

import java.util.*;
//TODO: didn't worked

public class leet_10 {
    public static void main(String[] args) {
        String patt =
                "mis*is*ip*.";
                // "c*a*b";
        String text =
                "mississippi";
                // "aab";
        System.out.println(memoization(patt, text));
    }

    public static boolean memoization(String patt, String text) {
        int pattn = patt.length(), textn = text.length();
        int dp[][] = new int[pattn][textn];
        for (int arr[] : dp)
            Arrays.fill(arr, -1);
        boolean result = memo(dp, patt, text, pattn - 1, textn - 1) != 0;
        for (int arr[] : dp)
            System.out.println(Arrays.toString(arr));
        return result;
    }

    public static int memo(int dp[][], String patt, String text, int i, int j) {
        if (i == -1) {
            return j == -1 ? 1 : 0;
        }
        if (j == -1) {
            while (i >= 0 && patt.charAt(i) == '*')
                i -= 2;
            return i == -1 ? 1 : 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = 0;

        if (patt.charAt(i) == '.' || patt.charAt(i) == text.charAt(j)) {
            dp[i][j] = memo(dp, patt, text, i - 1, j - 1);
        } else if (patt.charAt(i) == '*') {
            if (patt.charAt(i - 1) == '.' || patt.charAt(i - 1) == text.charAt(j)) {
                if (memo(dp, patt, text, i, j - 1) == 1 || memo(dp, patt, text, i - 2, j) == 1) {
                    dp[i][j] = 1;
                }
            } else {
                dp[i][j] = memo(dp, patt, text, i, j - 1);
            }
        }

        return dp[i][j];
    }

}