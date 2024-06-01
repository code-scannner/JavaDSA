package striverCP.trie;

import java.util.*;
import java.io.*;

public class Q2 {
    public static void main(String[] args) throws IOException {

        PrintWriter out = new PrintWriter(System.out);
        MyScan in = new MyScan(System.in);

        BTrie t = new BTrie();
        int n = in.nextInt();

        int msg[] = in.na(n);
        int key[] = in.na(n);
        for (int num : key)
            t.insert(num);
        for (int i = 0; i < n; i++)
            out.print(t.minXor(msg[i]) + " ");
            
        out.close();
    }
}

class TNode {
    TNode children[] = new TNode[2];
    int present = 0;

    boolean contains(int c) {
        return children[c] != null;
    }

    TNode get(int c) {
        return children[c];
    }

    void put(int c) {
        children[c] = new TNode();
    }
}

class BTrie {
    TNode root;

    public BTrie() {
        root = new TNode();
    }

    public void insert(int num) {
        TNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            if (!curr.contains(bit)) {
                curr.put(bit);
            }
            curr = curr.get(bit);
            curr.present++;
        }
    }

    public int minXor(int num) {
        TNode curr = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            if (curr.contains(bit) && curr.get(bit).present > 0) {
                curr = curr.get(bit);
            } else {
                curr = curr.get(1 - bit);
                xor |= (1 << i);
            }
            curr.present--;
        }

        return xor;
    }

}

class MyScan {
    BufferedReader br;
    StringTokenizer st;

    MyScan(BufferedReader br) {
        this.br = br;
    }

    public MyScan(InputStream in) {
        this(new BufferedReader(new InputStreamReader(in)));
    }

    public void findToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String next() {
        findToken();
        return st.nextToken();
    }

    public int[] na(int n) {
        int[] k = new int[n];
        for (int i = 0; i < n; i++) {
            k[i] = fi();
        }
        return k;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public int fi() {
        String t = next();
        int cur = 0;
        boolean n = t.charAt(0) == '-';
        for (int a = n ? 1 : 0; a < t.length(); a++) {
            cur = cur * 10 + t.charAt(a) - '0';
        }
        return n ? -cur : cur;
    }

}