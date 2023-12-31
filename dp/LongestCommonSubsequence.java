package dp;

public class LongestCommonSubsequence {
    public static int LCSmemo(int dp[][], String str1, String str2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return 1 + LCSmemo(dp, str1, str2, i - 1, j - 1);
        } else {
            return Math.max(
                    LCSmemo(dp, str1, str2, i - 1, j),
                    LCSmemo(dp, str1, str2, i, j - 1));
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
        int dp[] = new int[n + 1];
        int cnt = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int curr[] = new int[n + 1];
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    curr[j + 1] = 1 + dp[j];
                    if(curr[j + 1] > cnt){
                        str.append(str1.charAt(i));
                        cnt++;
                    }
                } else {
                    curr[j + 1] = Math.max(dp[j + 1], curr[j]);
                }
            }
            dp = curr;
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String str1 = "abced";
        String str2 = "acbde";
        int dp[][] = new int[str1.length()][str2.length()];
        System.out.println(LCSmemo(dp, str1, str2, dp.length - 1, dp[0].length - 1));
        System.out.println(LCStabulation(str1, str2));
        System.out.println();

        System.out.println(getLCS(str1, str2));
    }
}
