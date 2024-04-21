package trie;

class TrieNode {
    TrieNode children[] = new TrieNode[26];
    int prefix = 0;
    int word = 0;

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

public class AdvancedTrie {
    TrieNode root;

    public AdvancedTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c)) {
                curr.put(c);
            }
            curr = curr.get(c);
            curr.prefix++;
        }
        curr.word++;

    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c))
                return false;
            curr = curr.get(c);
        }
        return curr.word > 0;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.contains(c))
                return false;
            curr = curr.get(c);
        }
        return curr.prefix > 0;
    }

    public void erase(String word) {
        if (!search(word))
            return;
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.get(c);
            curr.prefix--;
        }
        curr.word--;
    }

    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c))
                return 0;
            curr = curr.get(c);
        }
        return curr.word;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.contains(c))
                return 0;
            curr = curr.get(c);
        }
        return curr.prefix;
    }

    public static void main(String[] args) {
        AdvancedTrie trie = new AdvancedTrie();
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("ape");
        trie.insert("pine");
        trie.insert("pineapple");
        trie.insert("apps");

        System.out.println(trie.search("aps"));
        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.println(trie.countWordsStartingWith("ap"));
        trie.erase("apple");
        System.out.println("After erasing one apple");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.println(trie.countWordsStartingWith("ap"));
        System.out.println(trie.countWordsEqualTo("apps"));

    }
}
