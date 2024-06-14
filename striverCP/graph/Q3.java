package striverCP.graph;

import java.util.*;
import java.io.*;

public class Q3 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cats[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cats[i] = sc.nextInt();
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        // out.println(adj);
        out.println(dfs(adj, 1, -1, 0, m, cats));

        out.close();
    }

    public static int dfs(List<List<Integer>> adj, int node, int parent, int cats, int m, int cat[]) {

        cats += cat[node];
        if(cat[node] == 0) cats = 0;

        if (cats > m) {
            return 0;
        }

        // if it is a leaf node
        if (adj.get(node).size() == 1 && adj.get(node).get(0) == parent) {
            return 1;
        }

        int cnt = 0;
        for (int next : adj.get(node)) {
            if (next != parent) {
                cnt += dfs(adj, next, node, cats, m, cat);
            }
        }
        return cnt;
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