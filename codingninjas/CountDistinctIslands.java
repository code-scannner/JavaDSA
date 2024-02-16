package codingninjas;

import java.util.*;

public class CountDistinctIslands {
    static int dirs[][] = {
            { 1, 0 },
            { 0, 1 },
            { -1, 0 },
            { 0, -1 },
    };

    static class Node {
        int i;
        int j;

        Node(int _i, int _j) {
            i = _i;
            j = _j;
        }
    }

    public static Set<List<Integer>> bfs(int[][] arr, int ix, int iy, boolean visited[][]) {
        Queue<Node> q = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();
        int m = arr.length, n = arr[0].length;
        q.offer(new Node(ix, iy));
        while (!q.isEmpty()) {
            Node node = q.poll();
            int i = node.i;
            int j = node.j;
            set.add(Arrays.asList(i - ix, j - iy));
            for (int dir[] : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < m && x >= 0 && y < n && y >= 0 && arr[x][y] != 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new Node(x, y));
                }
            }
        }
        return set;

    }

    public static int distinctIsland(int[][] arr, int n, int m) {
        Set<Set<List<Integer>>> set = new HashSet<>();
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    set.add(bfs(arr, i, j, visited));
                }
            }
        }
        return set.size();

    }

    public static void main(String[] args) {
        int grid[][] = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 1, 1, 0, 1, 0 }
        };
        System.out.println(distinctIsland(grid, grid.length, grid[0].length));
    }
}
