package codeforces.mar15;

import java.util.*;
import java.io.*;

public class A {

    public static void main(String[] args) throws IOException, java.lang.Exception {

        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for (int j = 0; j < N - 1; j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                List<Integer> l = new ArrayList<>();
                l.add(from);
                l.add(to);
                list.add(l);
            }

            System.out.println(ByteLanders.funct(N, list));

        }

        out.close();

    }

    static class ByteLanders {

        final static int DIST = 2;
        final static int MOD = 1000000007;

        public static int funct(int n, List<List<Integer>> roads) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (int i = 0; i < n; i++)
                graph.put(i, new HashSet<>());

            for (List<Integer> road : roads) {
                int u = road.get(0), v = road.get(1);
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            Map<Integer, Set<Integer>> extendedGraph = buildNewRoads(graph, n);
            return countHamiltonianCycles(extendedGraph, n);
        }

        private static Map<Integer, Set<Integer>> buildNewRoads(Map<Integer, Set<Integer>> graph, int n) {
            Map<Integer, Set<Integer>> newGraph = new HashMap<>();
            for (int i = 0; i < n; i++)
                newGraph.put(i, new HashSet<>(graph.get(i)));

            for (int city = 0; city < n; city++) {
                Set<Integer> visited = new HashSet<>();
                visited.add(city);
                explore(city, visited, city, DIST, graph, newGraph);
            }
            return newGraph;
        }

        private static void explore(int origin, Set<Integer> visited, int current, int stepsLeft,
                Map<Integer, Set<Integer>> graph, Map<Integer, Set<Integer>> newGraph) {
            if (stepsLeft == 0) {
                newGraph.get(origin).add(current);
                newGraph.get(current).add(origin);
                return;
            }
            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    explore(origin, new HashSet<>(visited), neighbor, stepsLeft - 1, graph, newGraph);
                }
            }
        }

        private static int countHamiltonianCycles(Map<Integer, Set<Integer>> graph, int n) {
            int[] distances = bfs(graph, n);
            return dfs(0, 0, new HashSet<>(), graph, distances, n);
        }

        private static int[] bfs(Map<Integer, Set<Integer>> graph, int n) {
            int[] distances = new int[n];
            Arrays.fill(distances, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            distances[0] = 0;

            while (!queue.isEmpty()) {
                int city = queue.poll();
                for (int neighbor : graph.get(city)) {
                    if (distances[neighbor] == -1) {
                        distances[neighbor] = distances[city] + 1;
                        queue.add(neighbor);
                    }
                }
            }
            return distances;
        }

        private static int dfs(int origin, int current, Set<Integer> visited,
                Map<Integer, Set<Integer>> graph, int[] distances, int n) {
            visited.add(current);

            if (visited.size() == n) {
                return graph.get(current).contains(origin) ? 1 : 0;
            }

            int result = 0;
            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    result = (result + dfs(origin, neighbor, new HashSet<>(visited), graph, distances, n)) % MOD;
                }
            }
            return result;
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

        void sort(int arr[]) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                list.add(arr[i]);
            Collections.sort(list);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
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
