package graph;

public class CountSubIslands {
    static int dirs[][] = {
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
    };

    public static boolean dfs(int[][] grid1, int[][] grid2, boolean[][] visited, int i, int j) {
        
        boolean result = true;
        if (grid1[i][j] != grid2[i][j])
             result = false;

        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x < grid1.length && y < grid1[0].length && x >= 0 && y >= 0 && !visited[x][y] && grid2[x][y] == 1) {
                visited[x][y] = true;
                result &= dfs(grid1, grid2, visited, x, y);
            }
        }
        return result;
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        boolean visited[][] = new boolean[m][n];
        int subIslands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (grid2[i][j] == 1 && dfs(grid1, grid2, visited, i, j))
                        subIslands++;
                }
            }
        }
        return subIslands;

    }

    public static void main(String[] args) {
        int grid1[][] = {
                { 1, 1, 1, 0, 0 },
                { 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 }
        },
                grid2[][] = {
                        { 1, 1, 1, 0, 0 },
                        { 0, 0, 1, 1, 1 },
                        { 0, 1, 0, 0, 0 },
                        { 1, 0, 1, 1, 0 },
                        { 0, 1, 0, 1, 0 }
                };
        System.out.println(countSubIslands(grid1, grid2));
    }
}
