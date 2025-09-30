package graph;

import java.util.*;

class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Pair))
            return false;
        Pair p = (Pair) o;
        return node == p.node && weight == p.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, weight);
    }
}

public class Dijkistra {

    public static int[] dijkistraOptimal(List<List<int[]>> adj, int src) {
        int V = adj.size(), MAX = Integer.MAX_VALUE;
        int[] dis = new int[V];

        Arrays.fill(dis, MAX);
        dis[src] = 0;
        
        // {node, dis}
        TreeSet<Pair> set = new TreeSet<>((a, b) -> a.weight != b.weight ? a.weight - b.weight : a.node - b.node);
        set.add(new Pair(src, 0));
        while (!set.isEmpty()) {
            Pair currNode = set.pollFirst();
            for (int next[] : adj.get(currNode.node)) {
                int nextEdge = next[0];
                int nextMin = currNode.weight + next[1];
                if (nextMin < dis[nextEdge]) {
                    set.remove(new Pair(nextEdge, dis[nextEdge]));
                    dis[nextEdge] = nextMin;
                    set.add(new Pair(nextEdge, nextMin));
                }
            }
        }
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] == MAX)
                dis[i] = -1; // indicating it is impossible to reach at that node
        }
        return dis;
    }

    public static int[] dijkistra(List<List<int[]>> adj, int src) {
        int V = adj.size(), MAX = (int) 1e9;
        int[] dis = new int[V];

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
                    pq.offer(new int[] { nextEdge, nextMin });
                }
            }
        }
        return dis;
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

    // for larger edge weights we need to use pair class to pass all testcases
    public static int count_ways_to_reach_destination_in_shortest_time(List<List<int[]>> adj, int src, int dest) {
        long MAX = (long) 1e12;
        int mod = (int) 1e9 + 7, n = adj.size();
        long[] dis = new long[n];
        int[] count = new int[n];
        count[src] = 1;
        Arrays.fill(dis, MAX);
        dis[src] = 0;
        // {node, dis}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { src, 0 });
        while (!pq.isEmpty()) {
            int[] currNode = pq.poll();
            for (int next[] : adj.get(currNode[0])) {
                int nextEdge = next[0];
                int nextMin = currNode[1] + next[1];
                if (nextMin < dis[nextEdge]) {
                    dis[nextEdge] = nextMin;
                    count[nextEdge] = count[currNode[0]];
                    pq.offer(new int[] { nextEdge, nextMin });
                } else if (nextMin == dis[nextEdge]) {
                    count[nextEdge] = (int) (((long) count[nextEdge] + count[currNode[0]]) % mod);
                }
            }
        }
        return count[dest];
    }

    public static void main(String[] args) {
        int edges[][] = {
                { 0, 2, 4 },
                { 0, 1, 4 },
                { 1, 2, 2 },
                { 2, 3, 3 },
                { 2, 4, 1 },
                { 2, 5, 6 },
                { 3, 5, 2 },
                { 4, 5, 3 }
        };
        List<List<int[]>> list = Graph.wgtUndirectedAdjList(edges, 6);
        int shortDis[] = dijkistra(list, 0);
        System.out.println(Arrays.toString(shortDis));
        List<Integer> path = shortest_path(list, 0);
        System.out.println(path);
        System.out.println("Number of ways to reach to destination 5 = " +
                count_ways_to_reach_destination_in_shortest_time(list, 0, 5));
    }
}
