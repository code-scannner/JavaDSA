package graph;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();

        Set<String> visited = new HashSet<>();

        Set<String> words = new HashSet<>();
        for (String word : wordList)
            words.add(word);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int out = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                String word = q.poll();
                if (word.equals(endWord))
                    return out;
                StringBuilder str = new StringBuilder(word);
                for (int i = 0; i < n; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        str.setCharAt(i, j);
                        String next = str.toString();
                        if (words.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    str.setCharAt(i, word.charAt(i));
                }
                size--;
            }
            out++;
        }

        return 0;
    }

    public static List<List<String>> findLadder(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();
        int n = beginWord.length();

        List<String> ans = new ArrayList<>();
        ans.add(beginWord);
        Queue<List<String>> q = new LinkedList<>();
        q.offer(ans);

        Set<String> words = new HashSet<>();
        for (String word : wordList)
            words.add(word);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> nextVisited = new HashSet<>();
            while (size > 0) {
                List<String> patt = q.poll();
                String lastWord = patt.get(patt.size() - 1);
                if (lastWord.equals(endWord))
                    result.add(patt);
                else {
                    StringBuilder str = new StringBuilder(lastWord);
                    for (int i = 0; i < n; i++) {
                        for (char j = 'a'; j <= 'z'; j++) {
                            str.setCharAt(i, j);
                            String next = str.toString();
                            if (words.contains(next) && !visited.contains(next)) {
                                List<String> nextPatt = new ArrayList<>(patt);
                                nextPatt.add(str.toString());
                                q.offer(nextPatt);
                                nextVisited.add(str.toString());
                            }
                        }
                        str.setCharAt(i, lastWord.charAt(i));
                    }
                }
                size--;
            }
            visited.addAll(nextVisited);
        }

        return result;
    }

    public static List<List<String>> findLadderLessTime(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();

        List<List<String>> result = new ArrayList<>();

        Set<String> visited = new HashSet<>();

        Set<String> words = new HashSet<>();
        for (String word : wordList)
            words.add(word);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);

        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 0);
        int out = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    map.put(word, out);
                    break;
                }
                map.put(word, out);

                StringBuilder str = new StringBuilder(word);
                for (int i = 0; i < n; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        str.setCharAt(i, j);
                        String next = str.toString();
                        if (words.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    str.setCharAt(i, word.charAt(i));
                }
                size--;
            }
            out++;
        }
        List<String> ans = new ArrayList<>();
        dfs(result, ans, out, map, endWord);

        System.out.println(map);
        return result;
    }

    public static void dfs(List<List<String>> result, List<String> ans, int i, Map<String, Integer> map, String word) {
        if (i == 0) {
            List<String> finalans = new ArrayList<>(ans);
            Collections.reverse(finalans);
            result.add(finalans);
            return;
        }

        StringBuilder str = new StringBuilder(word);

        for (int k = 0; k < word.length(); k++) {
            for (char j = 'a'; j <= 'z'; j++) {
                str.setCharAt(k, j);
                if (map.getOrDefault(str.toString(), -2) == i - 1) {
                    ans.add(str.toString());
                    dfs(result, ans, i - 1, map, str.toString());
                    ans.remove(ans.size() - 1);
                }
            }
            str.setCharAt(k, word.charAt(k));
        }

    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
        System.out.println(findLadder(beginWord, endWord, wordList));
        System.out.println(findLadderLessTime(beginWord, endWord, wordList));
    }
}