package striverCP.trie;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Trie t = new Trie();
        t.insert(0);
        for (int i = 0; i < q; i++) {
            char c = sc.next().charAt(0);
            if (c == '+')
                t.insert(sc.nextInt());
            else if (c == '-')
                t.erase(sc.nextInt());
            else
                System.out.println(t.maxXor(sc.nextInt()));
        }

        sc.close();
    }
}

class Node {
    Node children[] = new Node[2];
    int present = 0;

    boolean contains(int c) {
        return children[c] != null;
    }

    Node get(int c) {
        return children[c];
    }

    void put(int c) {
        children[c] = new Node();
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            if (!curr.contains(bit)) {
                curr.put(bit);
            }
            curr = curr.get(bit);
            curr.present++;
        }
    }

    public void erase(int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            curr = curr.get(bit);
            curr.present--;
        }
    }

    public int maxXor(int num) {
        Node curr = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            if (bit == 0 && curr.contains(1) && curr.get(1).present > 0) {
                curr = curr.get(1);
                xor |= (1 << i);
            } else if (bit == 1 && curr.contains(0) && curr.get(0).present > 0) {
                curr = curr.get(0);
                xor |= (1 << i);
            } else {
                curr = curr.get(bit);
            }
        }

        return xor;
    }

}
