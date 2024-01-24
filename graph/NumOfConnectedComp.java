package graph;

public class NumOfConnectedComp {
    public static void dfs(boolean[][] visited, int[][] graph, int i, int j) {
        if (i >= 0 && j >= 0 && i < graph.length && j < graph[0].length) {
            if (!visited[i][j]) {
                visited[i][j] = true;
                if (graph[i][j] == 1) {
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            dfs(visited, graph, i + k, j + l);
                        }
                    }
                }
            }
        }
    }

    public static int connectedComponents(int[][] graph) {
        int m = graph.length, n = graph[0].length;
        boolean visited[][] = new boolean[m][n];
        int connected = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    // bfs traversal
                    if (graph[i][j] == 1) {
                        dfs(visited, graph, i, j);
                        connected++;
                    }
                }
            }
        }

        return connected;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 1, 1, 0, 1 }
        };
        System.out.println(connectedComponents(matrix));
    }
}
