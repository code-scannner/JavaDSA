package striverCP.tree;

import java.util.*;
import java.io.*;

public class Q2 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        List<Integer> adj[] = new LinkedList[n + 1];
        int dp[][] = new int[n + 1][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            if (adj[x] == null)
                adj[x] = new LinkedList<>();
            if (adj[y] == null)
                adj[y] = new LinkedList<>();
            adj[x].add(y);
            adj[y].add(x);
        }

        int cnt = 0;
        if (n != 1)
            cnt = solve(adj, dp, 1, 0, 0);

        out.println(cnt);

        out.close();
    }

    // using the dp method
    public static int solve(List<Integer> adj[], int dp[][], int node, int parent, int marked) {

        if (dp[node][marked] != -1)
            return dp[node][marked];

        int ans = 0;

        int unmarked = 0;
        for (int next : adj[node]) {
            if (next != parent) {
                unmarked += solve(adj, dp, next, node, 0);
            }
        }
        if (marked == 1) {
            dp[node][1] = unmarked;
            return unmarked;
        }

        for (Integer next : adj[node]) {
            if (next != parent) {
                ans = Math.max(ans, 1 + unmarked - dp[next][0] + solve(adj, dp, next, node, 1));
            }
        }

        dp[node][0] = ans;

        return ans;
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