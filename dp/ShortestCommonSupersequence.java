package dp;

public class ShortestCommonSupersequence {
    public static int tabulation(String str1, String str2) {
        return str1.length() + str2.length() - LongestCommonSubsequence.LCStabulation(str1, str2);
    }

    public static String shortestSuperSequence(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        int dp[][] = new int[n1 + 1][n2 + 1]; 
        for(int i = 1; i<=n1 ; i++){
            for(int j = 1; j<=n2; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j  - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n1, j = n2;
        StringBuilder str = new StringBuilder();
        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                str.append(str1.charAt(i - 1));
                i--;j--;
            }
            else{
                if(dp[i - 1][j] >= dp[i][j - 1]){
                    i--;
                    str.append(str1.charAt(i));
                }
                else{
                    j--;
                    str.append(str2.charAt(j));
                }
            }
        }

        while(i > 0){
            str.append(str1.charAt(--i));
        }
        while(j > 0){
            str.append(str2.charAt(--j));
        }


        str.reverse();
        return str.toString();
    }
    
    public static void main(String[] args) {
        String str1 = "cab";
        String str2 = "abac";
        System.out.println(shortestSuperSequence(str1, str2));
    }
}
