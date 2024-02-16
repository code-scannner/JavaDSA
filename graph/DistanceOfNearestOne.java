package graph;

import java.util.*;

public class DistanceOfNearestOne {
    static class Node {
        int i;
        int j;
        int dis;

        Node(int _i, int _j, int _dis) {
            i = _i;
            j = _j;
            dis = _dis;
        }
    }

    public static int[][] nearestOne(int[][] grid) {
        int n = grid[0].length, m = grid.length;
        int result[][] = new int[m][n];
        boolean visited[][] = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new Node(i, j, 0));
                }
            }
        }

        int dirs[][] = {
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 },
        };

        while (!q.isEmpty()) {
            Node node = q.poll();
            int i = node.i;
            int j = node.j;
            int dis = node.dis;
            result[i][j] = dis;

            for (int dir[] : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < m && x >= 0 && y < n && y >= 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new Node(x, y, dis + 1));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 0, 1 }
        };
        int result[][] = nearestOne(grid);
        for (int is[] : result)
            System.out.println(Arrays.toString(is));
    }
}
