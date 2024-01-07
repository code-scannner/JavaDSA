package dp;

public class LCSpatt {
    public static int longestPalindromicSubsequence(String str) {
        return LongestCommonSubsequence.LCStabulation(str, new StringBuilder(str).reverse().toString());
    }

    public static String getLongestPalindrome(String str) {
        return LongestCommonSubsequence.getLCS(str, new StringBuilder(str).reverse().toString());
    }

    public static int insertionsForPalindromicString(String str) {
        return str.length() - longestPalindromicSubsequence(str);
    }

    public static int equalAandB(String A, String B) {
        // minimum insertions or deletions required to make string a and b equal
        return A.length() + B.length() - 2 * LongestCommonSubsequence.LCStabulation(A, B);
    }

    public static String shortestCommonSubsequence(String str1, String str2) {

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

        StringBuilder str = new StringBuilder();

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                str.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                str.append(str1.charAt(i - 1));
                i--;
            } else {
                str.append(str2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            str.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            str.append(str2.charAt(j - 1));
            j--;
        }

        return str.reverse().toString();
    }

    public static String SCSusingLCS(String A, String B) {
        // length = A.length() + B.length() - LongestCommonSubsequence.LCStabulation(A,
        // B);

        String lcs = LongestCommonSubsequence.getLCS(A, B);
        StringBuilder str = new StringBuilder();

        int k = 0, i = 0, j = 0, ni = A.length(), nj = B.length(), n = lcs.length();
        while (i < ni && j < nj && k < n) {
            if (A.charAt(i) == lcs.charAt(k) && B.charAt(j) == lcs.charAt(k)) {
                str.append(A.charAt(i));
                i++;
                j++;
                k++;
            } else if (A.charAt(i) == lcs.charAt(k)) {
                str.append(B.charAt(j++));
            } else if (B.charAt(j) == lcs.charAt(k)) {
                str.append(A.charAt(i++));
            } else {
                str.append(A.charAt(i++));
                str.append(B.charAt(j++));
            }
        }

        while (i < ni)
            str.append(A.charAt(i++));
        while (j < nj)
            str.append(B.charAt(j++));

        return str.toString();
    }

    public static void main(String[] args) {
        String str = "bbabcbcab";
        System.out.println(longestPalindromicSubsequence(str));
        // b b a b c b c a b
        // b a c b c b a b b

        System.out.println(getLongestPalindrome(str));
        // b a b c b a b

        System.out.println(insertionsForPalindromicString(str));

        System.out.println(equalAandB("abcd", "anc"));

        System.out.println(shortestCommonSubsequence("brute", "groot"));
    }
}
