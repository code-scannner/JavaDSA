package graph;

import java.util.*;

public class Graph {
    public static List<List<Integer>> adjMatrix(int[][] edges, int V) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < V; i++)
            result.add(new ArrayList<>());

        for (int[] edge : edges) {
            result.get(edge[0]).add(edge[1]);
        }
        return result;
    }

}
