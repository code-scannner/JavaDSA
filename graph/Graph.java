package graph;

import java.util.*;

public class Graph {
    public static List<List<int[]>> wgtAdjList(int edges[][], int n) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int[] edge : edges) {
            list.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }
        return list;
    }

    public static List<List<int[]>> wgtUndirectedAdjList(int edges[][], int n) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int[] edge : edges) {
            list.get(edge[0]).add(new int[] { edge[1], edge[2] });
            list.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }
        return list;
    }

    public static List<List<Integer>> adjList(int edges[][], int n) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
        }
        return list;
    }

    public static List<List<Integer>> undirectedAdjList(int edges[][], int n) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        return list;
    }

    public static List<List<Integer>> arrayToAdjList(int[][] edges, int V) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j : edges[i]) {
                list.add(j);
            }
            result.add(list);
        }

        return result;
    }

}
