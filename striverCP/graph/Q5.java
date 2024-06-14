package striverCP.graph;

import java.util.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> firstEdges = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<Integer>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
            firstEdges.add(u);
        }
        int result[] = new int[n + 1];
        Arrays.fill(result, -1);
        if (biParite(result, adj, 1, 1)) {
            out.println("YES");
            StringBuilder str = new StringBuilder();
            for (int edge : firstEdges) {
                str.append(result[edge]);
            }
            out.println(str);
        } else
            out.println("NO");

        out.close();
    }

    public static boolean biParite(int[] result, List<List<Integer>> adj, int node, int color) {
        result[node] = color;
        for (int next : adj.get(node)) {
            if (result[next] == color ||
                    result[next] == -1 && !biParite(result, adj, next, 1 - color))
                return false;
        }
        return true;
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