package striverCP.disjointsets;

import java.util.*;
import java.io.*;

public class Q6 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        int[] longestPath = new int[n + 1];
        DSU set = new DSU(n + 1);
        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            arr[i] = new ArrayList<>();
        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        boolean visited[] = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Queue<Integer> dq = new LinkedList<>();
                dq.offer(i);
                int nodes = 0;
                while (!dq.isEmpty()) {
                    int node = dq.poll();
                    for (int next : arr[node]) {
                        if (!visited[next]) {
                            visited[next] = true;
                            set.union(next, i);
                            dq.offer(next);
                        }
                    }
                    nodes++;
                }
                int parent = set.findParent(i);
                longestPath[parent] = nodes - 1;
            }
        }

        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                out.println(longestPath[set.findParent(x)] + " ");
            } else {
                int x = sc.nextInt(), y = sc.nextInt();
                int px = set.findParent(x), py = set.findParent(y);
                if (px != py) {
                    int path = (longestPath[px] + 1) / 2 + (longestPath[py] + 1) / 2 + 1;
                    set.union(x, y);
                    longestPath[set.findParent(x)] = path;
                }
            }
        }

        out.close();
    }

    static class DSU {
        int set[];

        DSU(int size) {
            set = new int[size];
            Arrays.fill(set, -1);
        }

        public int findParent(int node) {
            if (set[node] < 0)
                return node;
            // path compressssion
            return set[node] = findParent(set[node]);
        }

        public void union(int node1, int node2) {
            node1 = findParent(node1);
            node2 = findParent(node2);
            if (node1 == node2) // already connected
                return;

            if (set[node1] <= set[node2]) {
                set[node1] += set[node2];
                set[node2] = node1;
            } else {
                set[node2] += set[node1];
                set[node1] = node2;
            }
        }

        public boolean areConnected(int node1, int node2) {
            return findParent(node2) == findParent(node2);
        }

        public int connectedComponents() {
            int cnt = 0;
            for (int i = 0; i < set.length; i++) {
                if (set[i] < 0)
                    cnt++;
            }
            return cnt;
        }

        public int connectedElements(int node) {
            return -set[findParent(node)];
        }

        public int largestComponentSize() {
            int max = 0;
            for (int i = 0; i < set.length; i++) {
                if (set[i] < 0)
                    max = Math.max(max, -set[i]);
            }
            return max;
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