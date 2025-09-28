package segmenttree;

import java.util.*;

/*
 * given a grid of forest, where each cell is a tree
 * 1 represents - a tree is planted, 0 represents - no tree is there
 * query type 1 (get number of trees) - 
 *          -> get the number of trees in the range (x1, y1, x2, y2)
 * query type 2 (toggle tree) - 
 *          -> plant a tree at position (x, y) if there is empty space, 
 *             otherwise remove the tree from that position
 */

public class TwoD_BIT {
    public static List<Integer> solution(int grid[][], int q[][]) {
        List<Integer> ans = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        BinaryIndexedTree2D bit = new BinaryIndexedTree2D(m, n);

        // Build BIT
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bit.add(i, j, 1);
                }
            }
        }

        // Process queries
        for (int[] query : q) {
            int type = query[0];
            if (type == 1) {
                int x1 = query[1], y1 = query[2], x2 = query[3], y2 = query[4];
                ans.add(bit.sum(x1, y1, x2, y2));
            } else if (type == 2) {
                int x = query[1], y = query[2];
                if (grid[x][y] == 0) {
                    bit.add(x, y, 1);
                } else {
                    bit.add(x, y, -1);
                }
                grid[x][y] ^= 1; // toggle
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 1, 0, 0, 1, 1 },
                { 1, 0, 0, 1, 1 },
                { 1, 0, 0, 1, 1 },
                { 1, 0, 0, 1, 1 },
        };

        int q[][] = {
                { 1, 1, 1, 2, 2 }, // query rectangle (1,1) to (2,2)
                { 2, 1, 1 },       // toggle (1,1)
                { 2, 2, 2 },       // toggle (2,2)
                { 1, 1, 1, 2, 2 },  // query again
                { 2, 1, 1 },       // toggle (1,1)
                { 1, 1, 1, 2, 2 }  // query again
        };

        System.out.println(solution(grid, q)); // Expected [2, 1]
    }
}

// 2-D Fenwick Tree (Binary Indexed Tree) for Range Query + Point Update
class BinaryIndexedTree2D {
    int[][] bit;

    public BinaryIndexedTree2D(int m, int n) {
        bit = new int[m + 1][n + 1]; // 1-based indexing
    }

    public void add(int i, int j, int val) {
        i++;
        j++;
        while (i < bit.length) {
            int jj = j; // reset j for each i
            while (jj < bit[0].length) {
                bit[i][jj] += val;
                jj += jj & -jj;
            }
            i += i & -i;
        }
    }

    public int sum(int i, int j) {
        i++;
        j++;
        int s = 0;
        while (i > 0) {
            int jj = j;
            while (jj > 0) {
                s += bit[i][jj];
                jj -= jj & -jj;
            }
            i -= i & -i;
        }
        return s;
    }

    public int sum(int x1, int y1, int x2, int y2) {
        return sum(x2, y2)
             - sum(x1 - 1, y2)
             - sum(x2, y1 - 1)
             + sum(x1 - 1, y1 - 1);
    }
}
