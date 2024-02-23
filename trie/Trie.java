package trie;

class Node {
    Node links[] = new Node[26];
    int count = 0;
    int flag = 0;

    boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    Node get(char c) {
        return links[c - 'a'];
    }

    Node put(char c) {
        Node node = new Node();
        links[c - 'a'] = node;
        return node;
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
            curr.count++;
        }
        curr.flag++;

    }

    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c))
                return false;
            curr = curr.get(c);
        }
        return curr.flag > 0;
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

    public int countWordsEqualTo(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c))
                return 0;
            curr = curr.get(c);
        }
        return curr.flag;
    }

    public int countWordsStartingWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.contains(c))
                return 0;
            curr = curr.get(c);
        }
        return curr.count;
    }

    public void erase(String word) {
        if (!search(word))
            return;
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c))
                return;
            curr = curr.get(c);
            curr.count--;
        }
        curr.flag--;
    }

    public int countDistinctSubstring(String word){
        Node curr = root;
        int cnt = 0;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c)) {
                curr.put(c);
                cnt++;
            }
            curr = curr.get(c);
            curr.count++;
        }
        curr.flag++;
        return cnt;
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
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.println(trie.countWordsStartingWith("ap"));
        trie.erase("apple");
        System.out.println("After erasing one apple");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.println(trie.countWordsStartingWith("ap"));
        System.out.println(trie.countWordsEqualTo("apps"));

    }
}
