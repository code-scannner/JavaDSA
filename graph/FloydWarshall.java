package graph;

import java.util.*;

public class FloydWarshall {
    public static int[][] floydWarshall(int edges[][], int n) {

        // creating adjMatrix for directed edges
        int[][] adjMat = new int[n][n];
        int MAX = (int) 1e9;
        for (int arr[] : adjMat)
            Arrays.fill(arr, MAX);
        for (int[] edge : edges) {
            adjMat[edge[0]][edge[1]] = edge[2];
            // adjMat[edge[1]][edge[0]] = edge[2]; // for undirected edges
        }
        for (int i = 0; i < n; i++)
            adjMat[i][i] = 0;

        // algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
                }
            }
        }
        // detecting negative cycle
        for (int i = 0; i < n; i++) {
            if (adjMat[i][i] < 0)
                return new int[][] { { -1 } };
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMat[i][j] == MAX)
                    adjMat[i][j] = -1;
            }
        }

        return adjMat;

    }

    public static void main(String[] args) {
        int edges[][] = {
                { 0, 1, 2 },
                { 1, 0, 1 },
                { 3, 0, 3 },
                { 3, 1, 5 },
                { 3, 2, 4 },
                { 1, 2, 3 }
        };

        // negative cycle graph
        // int edges[][] = {
        // { 0, 1, -2 },
        // { 1, 2, -3 },
        // { 2, 0, 2 },
        // };

        int[][] cost = floydWarshall(edges, 4);
        for (int[] c : cost)
            System.out.println(Arrays.toString(c));
    }
}
