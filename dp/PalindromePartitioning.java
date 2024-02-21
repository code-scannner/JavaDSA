package dp;

import java.util.*;

public class PalindromePartitioning {
    public static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }

    public static int recursion(String str, int i) {
        if (i < str.length()) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < str.length(); j++) {
                if (isPalindrome(str, i, j)) {
                    min = Math.min(min, 1 + recursion(str, j + 1));
                }
            }
            return min;
        }
        return -1;
    }

    public static int memo(int dp[], String str, int i) {
        if (i < str.length()) {
            if (dp[i] != -1)
                return dp[i];
            int min = Integer.MAX_VALUE;
            for (int j = i; j < str.length(); j++) {
                if (isPalindrome(str, i, j)) {
                    min = Math.min(min, 1 + memo(dp, str, j + 1));
                }
            }
            dp[i] = min;
            return min;
        }
        return -1;
    }
    
    public static int tabulation(String str){
        int n = str.length();
        boolean palindrome[][] = new boolean[n][n];
        int i = 0, j = 0, k = 0;
        while(k < n){
            i = k;j = k;
            while(i >= 0 && j < n && str.charAt(i) == str.charAt(j)){
                palindrome[i][j] = true;
                i--;
                j++;
            }
            k++;
        }
        k = 0;
        while(k < n){
            i = k; j = k + 1;
            while(i >= 0 && j < n && str.charAt(i) == str.charAt(j)){
                palindrome[i][j] = true;
                i--;
                j++;
            }
            k++;
        }

        int dp[] = new int[n + 1];
        dp[n] = -1;
        for(i = n - 1; i>= 0 ; i-- ){
            int min = Integer.MAX_VALUE;
            for(j = i; j<n; j++){
                if(palindrome[i][j]){
                    min = Math.min(min, 1 + dp[j + 1]);
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String str = "bababcbadcede";
        System.out.println(recursion(str, 0));
        int dp[] = new int[str.length()];
        Arrays.fill(dp, -1);
        System.out.println(memo(dp, str, 0));
        System.out.println(tabulation(str));

    }
}
