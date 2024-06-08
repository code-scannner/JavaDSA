package striverCP.tree;

import java.util.*;
import java.io.*;

public class Q4 {
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
        int result[] = new int[n + 1];

        int farthestDis = 0;

        // first fartestNode
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 1, -1, 0 });
        while (!q.isEmpty()) {
            int node[] = q.poll();
            for (int next : adj.get(node[0])) {
                if (next != node[1]) {
                    q.offer(new int[] { next, node[0], node[2] + 1 });
                    farthestDis = Math.max(farthestDis, node[2] + 1);
                }
            }
        }
        q.offer(new int[] { 1, -1, 0 });
        while (!q.isEmpty()) {
            if (q.peek()[2] == farthestDis) {
                break;
            }
            int node[] = q.poll();
            for (int next : adj.get(node[0])) {
                if (next != node[1]) {
                    q.offer(new int[] { next, node[0], node[2] + 1 });
                }
            }
        }

        // added for some fartest elements
        for (int node[] : q) {
            result[node[0]]++;
        }

        // Diameter
        Queue<int[]> qu = new LinkedList<>();
        int d = 0;
        qu.offer(new int[] { q.iterator().next()[0], -1, 0 });
        while (!qu.isEmpty()) {
            int node[] = qu.poll();
            for (int next : adj.get(node[0])) {
                if (next != node[1]) {
                    qu.offer(new int[] { next, node[0], node[2] + 1 });
                    d = Math.max(d, node[2] + 1);
                }
            }
        }

        boolean visited[] = new boolean[n + 1];
        for (int node[] : q) {
            qu.offer(new int[] { node[0], -1, 0 });
            visited[node[0]] = true;
        }
        while (!qu.isEmpty()) {
            if (qu.peek()[2] == d)
                break;
            int node[] = qu.poll();
            for (int next : adj.get(node[0])) {
                if (next != node[1] && !visited[next]) {
                    visited[next] = true;
                    qu.offer(new int[] { next, node[0], node[2] + 1 });
                }
            }
        }

        for (int node[] : qu) {
            result[node[0]]++;
        }
        if (n == 1)
            out.print(1);
        else
            for (int i = 1; i <= n; i++) {
                out.print((result[i] + d) + " ");
            }

        out.println();

        out.close();
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