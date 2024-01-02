package graph;
import java.util.*;

public class Graph {
    public static List<Integer> bfs(ArrayList<Edge> graph[]) {
        List<Integer> list = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        boolean visited [] = new boolean[graph.length];
        q.offer(0);
        visited[0] = true;
        list.add(0);
        while (!q.isEmpty()) {
            int edge = q.poll();
            for (Edge neighbour : graph[edge]) {
                if(!visited[neighbour.dest]){
                    q.offer(neighbour.dest);
                    list.add(neighbour.src);
                    visited[neighbour.dest] = true;
                }
            }
        }
        return list;
    }

    public static ArrayList<Edge>[] createGraph(int [][] edgeList, int V){
        ArrayList<Edge> graph [] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int[] edge : edgeList) {
            graph[edge[0]].add(new Edge(edge[0], edge[1]));
        }

        return graph;
    }
    public static ArrayList<Edge>[] createWeightedGraph(int [][] edgeList, int V){
        ArrayList<Edge> graph [] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int[] edge : edgeList) {
            graph[edge[0]].add(new Edge(edge[0], edge[1], edge[2]));
        }

        return graph;
    }
}
