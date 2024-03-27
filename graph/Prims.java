package graph;

import java.util.*;

// Time Complexity = O(V^2)
// Extra Space Complexity O(V^2)
public class Prims {
    public static List<int[]> mst(int edges[][], int n) {
        List<List<int[]>> adj = Graph.wgtUndirectedAdjList(edges, n);

        boolean visited[] = new boolean[n];
        List<int[]> result = new ArrayList<>();

        // {parent, child, wgt}
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        pq.offer(new int[] { -1, 0, 0 });

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int parent = node[0], child = node[1];
            if (visited[child])
                continue;
            visited[child] = true;
            for (int nextNode[] : adj.get(child)) {
                if (!visited[nextNode[0]]) {
                    pq.offer(new int[] { child, nextNode[0], nextNode[1] });
                }
            }
            if (parent != -1)
                result.add(new int[] { parent, child });
        }

        return result;

    }

    public static int mstWeight(int edges[][], int n) {
        List<List<int[]>> adj = Graph.wgtUndirectedAdjList(edges, n);

        boolean visited[] = new boolean[n];
        int sum = 0;

        // {child, wgt}
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int child = node[0];
            if (visited[child])
                continue;
            visited[child] = true;
            for (int nextNode[] : adj.get(child)) {
                if (!visited[nextNode[0]]) {
                    pq.offer(new int[] { nextNode[0], nextNode[1] });
                }
            }
            sum += node[1];

        }

        return sum;

    }

    public static void main(String[] args) {
        int edges[][] = {
                { 0, 1, 2 },
                { 0, 2, 1 },
                { 2, 1, 1 },
                { 2, 4, 2 },
                { 2, 3, 2 },
                { 4, 3, 1 }
        };
        List<int[]> mstEdges = mst(edges, 5);
        for (int arr[] : mstEdges)
            System.out.println(Arrays.toString(arr));

        System.out.println(mstWeight(edges, 5));
    }
}
