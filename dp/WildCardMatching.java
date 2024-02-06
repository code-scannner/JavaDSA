package dp;

import java.util.*;

public class WildCardMatching {

    public static boolean recursion(String patt, String text, int i, int j) {
        if (i == -1) {
            return j == -1;
        }

        if (j == -1) {
            while (i >= 0)
                if (patt.charAt(i--) != '*')
                    return false;
            return true;
        }

        if (patt.charAt(i) == '?' || patt.charAt(i) == text.charAt(j)) {
            return recursion(patt, text, i - 1, j - 1);
        } else if (patt.charAt(i) == '*') {
            return recursion(patt, text, i - 1, j) || recursion(patt, text, i, j - 1);
        } else {
            return false;
        }
    }

    public static int memo(int dp[][], String patt, String text, int i, int j) {
        if (i == -1) {
            return j == -1 ? 1 : 0;
        }
        if (j == -1) {
            while (i >= 0)
                if (patt.charAt(i--) != '*')
                    return 0;
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = 0;

        if (patt.charAt(i) == '?' || patt.charAt(i) == text.charAt(j)) {
            dp[i][j] = memo(dp, patt, text, i - 1, j - 1);
        } else if (patt.charAt(i) == '*') {
            if (memo(dp, patt, text, i - 1, j) == 1 || memo(dp, patt, text, i, j - 1) == 1) {
                dp[i][j] = 1;
            }
        }

        return dp[i][j];
    }

    public static boolean memoization(String patt, String text) {
        int pattn = patt.length(), textn = text.length();
        int dp[][] = new int[pattn + 1][textn + 1];
        for (int arr[] : dp)
            Arrays.fill(arr, -1);
        return memo(dp, patt, text, pattn - 1, textn - 1) != 0;
    }

    public static boolean tabulation(String patt, String text) {

        int pattn = patt.length(), textn = text.length();

        boolean dp[] = new boolean[textn + 1];
        dp[0] = true;

        boolean star = true;

        for (int i = 1; i <= pattn; i++) {
            if (patt.charAt(i - 1) != '*')
                star = false;
            boolean curr[] = new boolean[textn + 1];
            curr[0] = star;
            for (int j = 1; j <= textn; j++) {
                if (patt.charAt(i - 1) == '?' || patt.charAt(i - 1) == text.charAt(j - 1)) {
                    curr[j] = dp[j - 1];
                } else if (patt.charAt(i - 1) == '*') {
                    if (dp[j] || curr[j - 1]) {
                        curr[j] = true;
                    }
                }
            }
            dp = curr;
        }

        return dp[textn];

    }

    public static void main(String[] args) {
        String patt = "ab*c?d";
        String text = "abdacxd";
        System.out.println(recursion(patt, text, patt.length() - 1, text.length() - 1));
        System.out.println(memoization(patt, text));
        System.out.println(tabulation(patt, text));
    }
}
