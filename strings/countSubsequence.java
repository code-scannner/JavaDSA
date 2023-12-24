package strings;
import java.util.*;

public class countSubsequence {
    public static int count(String str){
        int n = str.length();
        int dp[] = new int[n + 1];
        int idx[] = new int[26];
        Arrays.fill(idx, -1);
        dp[0] = 1;
        for(int i = 0; i<n; i++){
            char c = str.charAt(i);
            dp[i + 1] = dp[i] * 2;
            if(idx[c - 'a'] != -1){
                dp[i + 1] -= dp[idx[c - 'a']];
            }
            idx[c - 'a'] = i;
        }
        
        return dp[n];
        
    }

    public static void main(String[] args) {
        String str = "gfgg";
        System.out.println("Total subsequences in "  + str + " = " + count(str));
    }
}
