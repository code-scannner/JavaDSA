package striverCP.lca;

import java.util.*;
import java.io.*;

public class Q1 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj.get(v).add(u);
            adj.get(u).add(v);
        }

        int parent[] = new int[n + 1];

        dfs(parent, 1, -1, adj);

        int q = sc.nextInt();
        while (q-- > 0) {
            out.println(findClosest(parent, sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        out.close();
    }

    public static void dfs(int parent[], int node, int p, List<List<Integer>> adj) {
        for (int next : adj.get(node)) {
            if (next == p)
                continue;
            parent[next] = node;
            dfs(parent, next, node, adj);
        }
    }

    public static int findClosest(int[] parent, int start, int end, int c) {
        List<Integer> startAncestor = new ArrayList<>();
        List<Integer> endAncestor = new ArrayList<>();
        int i = start;
        while (parent[i] != 0) {
            startAncestor.add(i);
            i = parent[i];
        }
        i = end;
        while (parent[i] != 0) {
            endAncestor.add(i);
            i = parent[i];
        }
        Collections.reverse(startAncestor);
        Collections.reverse(endAncestor);
        i = 0;
        while (i < startAncestor.size() && i < endAncestor.size()) {
            if (startAncestor.get(i) != endAncestor.get(i)) {
                break;
            }
            i++;
        }

        int stepsToReachStart = startAncestor.size() - i;
        int stepsToReachEnd = endAncestor.size() - i;
        if (c <= stepsToReachStart) {
            return startAncestor.get(startAncestor.size() - c - 1);
        }
        c -= stepsToReachStart;
        if (c >= stepsToReachEnd) {
            return end;
        }

        return endAncestor.get(endAncestor.size() - c - 1);

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