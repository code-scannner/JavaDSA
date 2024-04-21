package trie;

public class CountDistinctSubstrings {

    // for word - aaaaa
    // distinct substrings are a, aa, aaa, aaaa, aaaaa; counted only once

    public static int count(String word, Trie trie) {
        Node curr = trie.root;
        int cnt = 0;
        for(char c : word.toCharArray()){
            if(!curr.contains(c)){
                curr.put(c);
                cnt++;
            }
            curr = curr.get(c);
        }
        return cnt;
    }
    public static int countDistinctSubstrings(String s) {
        int cnt = 0;
        Trie trie = new Trie();

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i);
            int distinctCount = count(str, trie);
            cnt+= distinctCount;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countDistinctSubstrings("abab"));
        System.out.println(countDistinctSubstrings("aaaaa"));
    }
}
