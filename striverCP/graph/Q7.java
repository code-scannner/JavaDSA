package striverCP.graph;

import java.util.*;
import java.io.*;

public class Q7 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt(), w = sc.nextInt();
            adj.get(x).add(new int[] { y, w });
            adj.get(y).add(new int[] { x, w });
        }
        
        List<Integer> path = shortest_path(adj, 1);

        for(int p : path) out.print(p + " ");
        out.println();

        out.close();
    }
    public static List<Integer> shortest_path(List<List<int[]>> adj, int src) {
        int V = adj.size(), MAX = (int) 1e9;
        int[] dis = new int[V];
        int[] parent = new int[V];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        Arrays.fill(dis, MAX);

        dis[src] = 0;
        // {node, dis}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { src, 0 });
        while (!pq.isEmpty()) {
            int[] currNode = pq.poll();
            for (int next[] : adj.get(currNode[0])) {
                int nextEdge = next[0];
                int nextMin = currNode[1] + next[1];
                if (nextMin < dis[nextEdge]) {
                    dis[nextEdge] = nextMin;
                    parent[nextEdge] = currNode[0];
                    pq.offer(new int[] { nextEdge, nextMin });
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int i = adj.size() - 1;
        while (parent[i] != i) {
            path.add(i);
            i = parent[i];
        }
        if (i == src) {
            path.add(src);
            Collections.reverse(path);
            return path;
        }
        return Arrays.asList(-1);
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