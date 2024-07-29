package graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        Solution sol = new Solution();
        System.out.println(sol.findLadders(beginWord, endWord, wordList));
    }

}

class Solution {
    Set<String> words = new HashSet<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            words.add(word);
        }
        if(!words.contains(endWord)) return result;
        words.add(beginWord);
        int length = ladderLength(endWord, beginWord);
        System.out.println(length);
        dfs(endWord, beginWord, length);
        return result;

    }

    public boolean oneDiff(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                cnt++;
            if (cnt > 1)
                return false;
        }
        return cnt == 1;
    }

    public int ladderLength(String beginWord, String endWord) {
        class Node {
            String word;
            int depth;

            Node(String s, int d) {
                word = s;
                depth = d;
            }
        }
        Set<String> visited = new HashSet<>();

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(beginWord, 0));
        visited.add(beginWord);

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.word.equals(endWord))
                return node.depth;
            for (String word : words) {
                if (oneDiff(word, node.word) && !visited.contains(word)) {
                    visited.add(word);
                    q.offer(new Node(word, node.depth + 1));
                }
            }
        }

        return 0;
    }

    public List<List<String>> dfs(String beginWord, String endWord, int n) {
        List<String> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        _dfs(ans, visited, beginWord, endWord, n);
        return result;
    }

    public void _dfs(List<String> ans, Set<String> visited, String beginWord, String endWord, int n) {

        if (n < 0)
            return;

        if (beginWord.equals(endWord)) {
            ans.add(endWord);
            List<String> res = new ArrayList<>(ans);
            Collections.reverse(res);
            result.add(res);
            ans.remove(ans.size() - 1);
            return;
        }
        ans.add(beginWord);

        for (String next : words) {
            if (oneDiff(next, beginWord) && !visited.contains(next)) {
                visited.add(next);
                _dfs(ans, visited, next, endWord, n - 1);
                visited.remove(next);
            }
        }
        ans.remove(ans.size() - 1);
    }
}