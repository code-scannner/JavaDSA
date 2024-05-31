package striverCP.string;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String goodness = sc.next();
        int k = sc.nextInt();
        int count = 0;
        Trie trie = new Trie();
        for (int i = 0; i < str.length(); i++) {
            int res = trie.insert(str.substring(i), goodness, k);
            count += res;

        }
        System.out.println(count);
        sc.close();
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public int insert(String word, String baddness, int k) {
        Node curr = root;
        int count = 0;
        int currBaddNess = 0;
        for (char c : word.toCharArray()) {
            if (baddness.charAt(c - 'a') == '0')
                currBaddNess++;
            if (currBaddNess > k)
                return count;
            if (!curr.contains(c)) {
                curr.put(c);
                count++;
            }
            curr = curr.get(c);
        }

        return count;
    }
}

class Node {
    Node children[] = new Node[26];

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
