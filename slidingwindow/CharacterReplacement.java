package slidingwindow;

public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int left = 0, right = 0, n = s.length();
        int popCount = 0;
        int max = 0;
        int dp[] = new int[92];
        while (right < n) {
            if (right - left - popCount <= k) {
                char c = s.charAt(right++);
                System.out.println(right + "left = " + left);
                dp[c]++;
                popCount = Math.max(popCount, dp[c]);
                max = Math.max(max, right - left - 1);
            } else {
                while (left < right && dp[s.charAt(left)] != popCount) {
                    dp[s.charAt(left++)]--;
                }
                dp[s.charAt(left++)]--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "ABAB";
        System.out.println(characterReplacement(str, 2));
    }
}
