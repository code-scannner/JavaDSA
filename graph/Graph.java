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
    public static List<List<Integer>> arrayToAdjMatrix(int[][] edges, int V) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < V; i++){
            List<Integer> list = new ArrayList<>();
            for(int j : edges[i]){
                list.add(j);
            }
            result.add(list);
        }

        return result;
    }

}
