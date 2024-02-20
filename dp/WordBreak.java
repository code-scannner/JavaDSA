package dp;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String word, List<String> wordDict) {
        int n = word.length();
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (String w : wordDict) {
                if (i >= w.length() - 1) {
                    int j = w.length() - 1;
                    int k = i;
                    while (j >= 0) {
                        if (w.charAt(j) != word.charAt(k))
                            break;
                        j--;
                        k--;
                    }
                    if (j == -1) {
                        dp[i + 1] = dp[i + 1] | dp[i - w.length() + 1];
                    }
                }
            }
        }

        return dp[n];
    }

    public static List<String> memo(List<List<String>> dp, int i, String word, List<String> wordDict) {
        if (i == word.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        if (dp.get(i) != null)
            return dp.get(i);
        List<String> ans = new ArrayList<>();
        for (String w : wordDict) {
            int j = 0;
            int k = i;
            while (k < word.length() && j < w.length()) {
                if (w.charAt(j) != word.charAt(k))
                    break;
                j++;
                k++;
            }
            if (j == w.length()) {
                List<String> next = memo(dp, i + w.length(), word, wordDict);
                if (next != null)
                    for (String str : next) {
                        ans.add(w + (str.length() == 0 ? "" : " ") + str);
                    }
            }
        }
        dp.set(i, ans);
        return ans;
    }

    public static List<String> printWordBreaks(String word, List<String> wordDict) {
        int n = word.length();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ans.add(null);
        }
        return memo(ans, 0, word, wordDict);
    }

    public static void main(String[] args) {
        // String s = "leetcode", wordDict[] = {"leet","code"};
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        // String s = "applepenapple", wordDict[] = { "apple", "pen" };
        // String s = "dogs", wordDict[] = { "dog", "s", "gs" };
        System.out.println(wordBreak(s, wordDict));
        System.out.println(printWordBreaks(s, wordDict));

    }
}
