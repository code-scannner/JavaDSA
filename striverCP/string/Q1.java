package striverCP.string;

import java.util.*;
import java.io.*;

// Good Strings

public class Q1 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        char [] str = sc.next().toCharArray();
        char[] goodness = sc.next().toCharArray();
        int k = sc.nextInt();

        out.println(usingHashing(str, k, goodness));

        out.close();
    }

    public static int usingHashing(char[] str, int k, char[] goodness) {
        int n = str.length;
        int badness[] = new int[n + 1];

        // prefix sum of baddness
        for (int i = 1; i < badness.length; i++) {
            badness[i] += badness[i - 1];
            if (goodness[str[i-1] - 'a'] == '0')
                badness[i]++;
        }

        int cnt = 0;
        Set<Long> hash = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long a = 0;
            for (int j = i; j < n; j++) {
                a = a * 29 + (str[j] - 'a' + 1);
                if(badness[j + 1] - badness[i] <= k){
                    
                    // cnt only if not in hash
                    if(!hash.contains(a)){
                        hash.add(a);
                        cnt++;
                    }
                }
                else break;
            }
        }

        return cnt;
    }

    public static int usingTrie(String str, int k, String goodness) {
        int count = 0;
        Trie trie = new Trie();
        for (int i = 0; i < str.length(); i++) {
            int res = trie.insert(str, i, goodness, k);
            count += res;
        }
        return count;
    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public int insert(String word, int begin, String baddness, int k) {
            Node curr = root;
            int count = 0;
            int currBaddNess = 0;
            for (int i = begin; i < word.length(); i++) {
                char c = word.charAt(i);
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

    static class Node {
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