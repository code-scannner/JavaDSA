package striverCP.trie;

import java.util.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws IOException {

        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        Trie trie = new Trie();
        int n = sc.nextInt();
        String[] arr = sc.nstr(n);
        for (String str : arr) {
            trie.insert(str);
        }
        for (String str : arr) {
            out.println(trie.min(str));
        }

        out.close();
    }

    static int MAX = 10;

    static class Node {
        Node children[] = new Node[MAX];
        int substrings = 0;

        boolean contains(char c) {
            return children[c - '0'] != null;
        }

        Node get(char c) {
            return children[c - '0'];
        }

        void put(char c) {
            children[c - '0'] = new Node();
        }

    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            for (int i = 0; i < 9; i++) {
                insertWord(word.substring(i));
            }
        }

        public void insertWord(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.contains(c)) {
                    curr.put(c);
                }
                curr = curr.get(c);
                curr.substrings++;
            }
        }

        public void erase(String word) {
            for (int i = 0; i < 9; i++) {
                eraseWord(word.substring(i));
            }
        }

        public void eraseWord(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                curr = curr.get(c);
                curr.substrings--;
            }
        }

        public int lastIndex(String word) {
            Node curr = root;
            int i = 0;
            for (char c : word.toCharArray()) {
                if (!curr.contains(c) || (curr.contains(c) && curr.get(c).substrings == 0)) {
                    return i + 1;
                }
                curr = curr.get(c);
                i++;
            }
            return 10;
        }

        public String min(String word) {
            erase(word);
            int start = 0, end = 9;
            // end - start = length of min string till now
            for (int i = 0; i < 9; i++) {
                if(end - start == 1) break;
                int last = i + lastIndex(word.substring(i));
                if (end - start > last - i) {
                    start = i;
                    end = last;
                }
            }

            insert(word);
            return word.substring(start, end);
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

        int[] narr(int n) throws IOException {
            int result[] = new int[n];
            for (int i = 0; i < n; i++)
                result[i] = nextInt();
            return result;
        }

        String[] nstr(int n) throws IOException {
            String result[] = new String[n];
            for (int i = 0; i < n; i++)
                result[i] = next();
            return result;
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
