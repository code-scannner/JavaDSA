package striverCP.tree;

import java.util.*;
import java.io.*;

public class Q3 {
    static class Node{
        List<Integer> list;
        
    }
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        int[] d = new int[1];
        int res = maxHeight(d, adj, 1, 0);
        d[0] = Math.max(d[0], res);
        out.println(3 * Math.max(0, d[0] - 1));

        out.close();
    }

    public static int maxHeight(int d[], List<List<Integer>> adj, int node, int parent) {

        int max = 0;
        for (int next : adj.get(node)) {
            if (next != parent) {
                int nextHeight = maxHeight(d, adj, next, node);
                d[0] = Math.max(d[0], max + nextHeight + 1);
                max = Math.max(max, nextHeight);
            }
        }

        return 1 + max;

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