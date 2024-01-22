package dp;

public class LongestCommonSubsequence {
    public static int LCSrecursion(int dp[][], String str1, String str2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return 1 + LCSrecursion(dp, str1, str2, i - 1, j - 1);
        } else {
            return Math.max(
                    LCSrecursion(dp, str1, str2, i - 1, j),
                    LCSrecursion(dp, str1, str2, i, j - 1));
        }
    }

    public static int LCStabulation(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int dp[] = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int curr[] = new int[n + 1];
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    curr[j + 1] = 1 + dp[j];
                } else {
                    curr[j + 1] = Math.max(dp[j + 1], curr[j]);
                }

            }
            dp = curr;
        }

        return dp[n];
    }

    public static String getLCS(String str1, String str2) {

        int m = str1.length(), n = str2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        int i = m, j = n;
        StringBuilder str = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                str.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "abced";
        String str2 = "acbde";
        int dp[][] = new int[str1.length()][str2.length()];
        System.out.println(LCSrecursion(dp, str1, str2, dp.length - 1, dp[0].length - 1));
        System.out.println(LCStabulation(str1, str2));

        System.out.println(getLCS(str1, str2));
    }
}
