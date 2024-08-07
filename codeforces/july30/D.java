package codeforces.july30;

import java.util.*;

import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                adj.add(new ArrayList<>());
            for (int i = 2; i <= n; i++) {
                adj.get(sc.nextInt()).add(i);
            }

            System.out.println(dfs(1, adj, a));

        }

        out.close();
    }

    public static long dfs(int node, List<List<Integer>> adj, int a[]) {
        if (adj.get(node).size() == 0) {
            // root node
            return a[node];
        }
        long s = 0;
        long min = Long.MAX_VALUE;
        for (int child : adj.get(node)) {
            min = Math.min(min, dfs(child, adj, a));
        }
        s = min + a[node];

        // System.out.printf("for %d, %d\n", node, s);
        return s;
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