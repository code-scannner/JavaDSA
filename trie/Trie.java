package trie;

class Node {
    Node children[] = new Node[26];
    boolean isLeaf = false;

    boolean contains(char c) {
        return children[c - 'a'] != null;
    }

    Node get(char c) {
        return children[c - 'a'];
    }

    void put(char c) {
        children[c - 'a'] = new Node();
    }
}

public class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c)) {
                curr.put(c);
            }
            curr = curr.get(c);
        }
        curr.isLeaf = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c))
                return false;
            curr = curr.get(c);
        }
        return curr.isLeaf;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.contains(c))
                return false;
            curr = curr.get(c);
        }
        return true;
    }

    // the erase function can only work with insert 
    // not with startswith because it erases only the word not its prefixes
    // for using it with startswith we can use advance trie
    public void erase(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c))
                return;
            curr = curr.get(c);
        }
        curr.isLeaf = false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("ape");
        trie.insert("pine");
        trie.insert("pineapple");
        trie.insert("apps");

        System.out.println(trie.search("aps"));
        System.out.println(trie.startsWith("ap"));
        trie.erase("apple");
        System.out.println(trie.search("apple"));

    }
}
