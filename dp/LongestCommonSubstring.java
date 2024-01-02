package dp;

public class LongestCommonSubstring {
    
    public static int tabulation(String str1, String str2) {
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

    public static void main(String[] args) {
        String str1 = "abced";
        String str2 = "acbde";
        
        System.out.println(tabulation(str1, str2));
    }
}
