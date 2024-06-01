package trie;

class BinaryNode {
    BinaryNode one, zero;

    boolean contains(int i) {
        return i == 0 && zero != null || i == 1 && one != null;
    }

    BinaryNode get(int i) {
        return i == 1 ? one : zero;
    }

    void put(int i) {
        if(i == 1) one = new BinaryNode();
        else zero = new BinaryNode();
    }
}

public class BinaryTrie {

    int bits = 32;

    BinaryNode root = new BinaryNode();

    public static void main(String[] args) {
        int arr1[] = { 3, 10, 5, 25, 2, 8 };
        BinaryTrie trie = new BinaryTrie();
        for (int num : arr1)
            trie.insert(num);
        System.out.println(trie.maxXor(23));
        System.out.println(trie.maxXor(21));

    }

    void insert(int num) {
        BinaryNode curr = root;
        for (int i = bits - 1; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            if (!curr.contains(bit)) {
                curr.put(bit);
            }
            curr = curr.get(bit);
        }
    }

    boolean search(int num) {
        BinaryNode curr = root;
        for (int i = bits - 1; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            if (!curr.contains(bit))
                return false;
            curr = curr.get(bit);
        }
        return true;
    }

    int maxXor(int num) {
        BinaryNode curr = root;
        int xor = 0;
        for (int i = bits - 1; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            if (bit == 1 && curr.contains(0)) {
                curr = curr.get(0);
                xor |= (1 << i);
            } else if (bit == 0 && curr.contains(1)) {
                curr = curr.get(1);
                xor |= (1 << i);
            } else {
                curr = curr.get(bit);
            }
        }
        return xor;
    }

    int minXor(int num) {
        BinaryNode curr = root;
        int xor = 0;
        for (int i = bits - 1; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            if (curr.contains(bit)) {
                curr = curr.get(bit);
            } else {
                curr = curr.get(1 - bit);
                xor |= (1 << i);
            }
        }
        return xor;
    }
}
