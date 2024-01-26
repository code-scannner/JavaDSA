package dp;

import java.util.*;

public class EditDistance {
    public static int recursion(String str1, String str2, int i, int j) {
        // if pattern ends and string still remains to match
        // the rest of the string needs to be deleted
        if (j == -1)
            return i + 1;

        // if the string to match ends and we still need to match pattern
        // the pattern length j + 1 insertions;
        if (i == -1)
            return j + 1;

        if (str1.charAt(i) == str2.charAt(j)) {
            return recursion(str1, str2, i - 1, j - 1);
        } else {
            return 1 + Math.min(
                    recursion(str1, str2, i - 1, j), // if deleting the char in string
                    recursion(str1, str2, i - 1, j - 1) // if replacing the char in string
            );
        }
    }

    public static int memoization(String str1, String str2) {
        int dp[][] = new int[str1.length()][str2.length()];
        for (int arr[] : dp)
            Arrays.fill(arr, -1);

        int minOperations = memo(dp, str1, str2, dp.length - 1, dp[0].length - 1);

        return minOperations;

    }

    public static int memo(int dp[][], String str1, String str2, int i, int j) {
        if (j == -1)
            return i + 1;

        if (i == -1)
            return j + 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = memo(dp, str1, str2, i - 1, j - 1);
        } else {
            dp[i][j] = 1 + Math.min(
                    memo(dp, str1, str2, i - 1, j),
                    memo(dp, str1, str2, i - 1, j - 1));
        }

        return dp[i][j];
    }

    public static int tabulation(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int dp[] = new int[n + 1];
        for (int j = 1; j <= n; j++)
            dp[j] = j;
        for (int i = 1; i <= m; i++) {
            int curr[] = new int[n + 1];
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = dp[j - 1];
                } else {
                    curr[j] = 1 + Math.min(
                            dp[j - 1], // for replacing
                            curr[j - 1] // for deleting chars
                    );
                }
            }
            dp = curr;
        }

        return dp[n];

    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(recursion(str1, str2, str1.length() - 1, str2.length() - 1));
        System.out.println(memoization(str1, str2));
        System.out.println(tabulation(str1, str2));
    }
}
