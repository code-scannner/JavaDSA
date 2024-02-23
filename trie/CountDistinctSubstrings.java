package trie;

public class CountDistinctSubstrings {
    public static int countDistinctSubstrings(String s) {
        int count = 0;
        Trie trie = new Trie();

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i);
            int distinctCount = trie.countDistinctSubstring(str);
            count+= distinctCount;
        }

        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(countDistinctSubstrings("abab"));
    }
}
