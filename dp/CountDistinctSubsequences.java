package dp;

import java.util.*;

public class CountDistinctSubsequences {
    public static int recursion(String str1, String str2, int i, int j) {
        if (j == -1)
            return 1;
        if (i == -1)
            return 0;
        int result = 0;
        if (str1.charAt(i) == str2.charAt(j)) {
            result = recursion(str1, str2, i - 1, j - 1);
        }

        result += recursion(str1, str2, i - 1, j);
        return result;
    }

    public static int memo(int dp[][], String str1, String str2, int i, int j) {
        if (j == -1)
            return 1;
        if (i == -1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int result = 0;
        if (str1.charAt(i) == str2.charAt(j)) {
            result = memo(dp, str1, str2, i - 1, j - 1);
        }

        result += memo(dp, str1, str2, i - 1, j);
        dp[i][j] = result;
        return result;
    }

    public static int memoization(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        int dp[][] = new int[n1][n2];

        for (int is[] : dp) {
            Arrays.fill(is, -1);
        }

        return memo(dp, str1, str2, n1 - 1, n2 - 1);

    }

    public static int tabulation(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        int dp[][] = new int[n2 + 1][n1 + 1];

        for(int j = 0; j<=n1; j++) dp[0][j] = 1;

        for (int i = 1; i <= n2; i++) {
            for (int j = 1; j <= n1; j++) {
                if(str1.charAt(j - 1) == str2.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] += dp[i][j - 1];
            }
        }

        return dp[n2][n1];
    }

    public static void main(String[] args) {
        String str1 = "babgbag";
        String str2 = "bag";

        System.out.println(recursion(str1, str2, str1.length() - 1, str2.length() - 1));
        System.out.println(memoization(str1, str2));
        System.out.println(tabulation(str1, str2));

    }
}
