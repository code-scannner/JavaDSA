package graph;

import java.util.*;

public class RottenOranges {
    public static boolean insideGrid(int m, int n, int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }

    public static int rottenOranges(int[][] graph) {
        int dirs[][] = {
                { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
        };
        int m = graph.length, n = graph[0].length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 2) {
                    int node = i * n + j;
                    q.add(node);
                }
            }
        }

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int node = q.poll();
                int row = node / n;
                int col = node % n;
                for (int dir[] : dirs) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    int nextNode = nextRow * n + nextCol;
                    if (insideGrid(m, n, nextRow, nextCol) &&
                            graph[nextRow][nextCol] == 1) {
                        graph[nextRow][nextCol] = 2;
                        q.add(nextNode);
                    }
                }
                size--;
            }
            time++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1)
                    return -1;
            }
        }

        return time == 0 ? 0 : -1;

    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        // int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(rottenOranges(grid));
    }
}
