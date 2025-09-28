package systemDesign;

import java.util.*;

public class AutocompleteSystem {

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = { "apple", "app", "appl", "bat", "ball", "batman" };
        for (String word : words) {
            trie.insert(word);
        }

        System.out.println(trie.search("batm", 1));
    }
}

class TrieNode {
    TrieNode children[] = new TrieNode[26];
    boolean isEnd = false;

    boolean contains(char c) {
        return children[c - 'a'] != null;
    }

    TrieNode get(char c) {
        return children[c - 'a'];
    }

    void put(char c) {
        children[c - 'a'] = new TrieNode();
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c)) {
                curr.put(c);
            }
            curr = curr.get(c);
        }
        curr.isEnd = true;
    }

    public List<String> search(String word, int k) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c))
                return new ArrayList<>();
            curr = curr.get(c);
        }
        List<String> res = new ArrayList<>();
        dfs(curr, new StringBuilder(word), res, k);
        return res;
    }

    private void dfs(TrieNode node, StringBuilder sb, List<String> res, int k) {
        if (res.size() == k)
            return;
        if (node.isEnd) {
            res.add(sb.toString());
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.contains(c)) {
                sb.append(c);
                dfs(node.get(c), sb, res, k);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
