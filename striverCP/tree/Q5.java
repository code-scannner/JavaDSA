package striverCP.tree;

import java.util.*;
import java.io.*;

public class Q5 {
    static class Node {
        List<Integer> list = new ArrayList<>();
        int subs = 0;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), q = sc.nextInt();
        List<Node> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new Node());
        for (int i = 2; i <= n; i++) {
            int p = sc.nextInt();
            adj.get(p).list.add(i);
        }
        for (Node node : adj) {
            node.list.sort(null);
        }
        dfs(adj, 1);

        while (q-- > 0) {
            int u = sc.nextInt(), k = sc.nextInt();
            out.println(query(adj, u, k));
        }

        out.close();
    }

    public static int query(List<Node> adj, int u, int k) {
        if (k == 1) {
            return u;
        }
        for (int next : adj.get(u).list) {
            if (k - 1 <= adj.get(next).subs) {
                return query(adj, next, k - 1);
            }
            k-= adj.get(next).subs;
        }

        return -1;

    }

    public static int dfs(List<Node> adj, int node) {
        int nodes = 1;

        for (int next : adj.get(node).list) {
            nodes += dfs(adj, next);
        }
        adj.get(node).subs = nodes;
        return nodes;
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