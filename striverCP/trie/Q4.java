package striverCP.trie;

import java.util.*;
import java.io.*;

public class Q4 {
    public static void main(String[] args) throws IOException {

        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        Trie trie = new Trie();
        int n = sc.nextInt();

        while (n-- > 0)
            trie.insert(sc.nextInt());
        int res = trie.min();
        out.println(res);

        out.close();
    }

    static int MAX = 30;

    static class Node {
        Node one, zero;

        boolean contains(int c) {
            return c == 0 && zero != null || c == 1 && one != null;
        }

        Node get(int c) {
            return c == 1 ? one : zero;
        }

        void put(int c) {
            if(c == 1) one = new Node();
            else zero = new Node();
        }
    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(int num) {
            Node curr = root;
            for (int i = MAX; i >= 0; i--) {
                int bit = (num & (1 << i)) == 0 ? 0 : 1;
                if (!curr.contains(bit)) {
                    curr.put(bit);
                }
                curr = curr.get(bit);
            }
        }

        public int min() {
            return min(root, MAX);
        }

        private int min(Node curr, int i) {
            if (i == -1)
                return 0;
            if (curr.contains(0) && curr.contains(1)) {
                return (1 << i) | Math.min(min(curr.get(0), i - 1), min(curr.get(1), i - 1));
            }
            if (curr.contains(0)) {
                return min(curr.get(0), i - 1);
            }
            return min(curr.get(1), i - 1);
        }

    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }

        boolean ready() throws IOException {
            return br.ready();
        }

    }
}
