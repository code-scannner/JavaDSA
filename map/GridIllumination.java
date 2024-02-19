package map;

import java.util.*;

public class GridIllumination {
    public static void main(String[] args) {
        int lamps[][] = { { 2, 5 }, { 4, 2 }, { 0, 3 }, { 0, 5 }, { 1, 4 }, { 4, 2 }, { 3, 3 }, { 1, 0 } };
        int queries[][] = { { 4, 3 }, { 3, 1 }, { 5, 3 }, { 0, 5 }, { 4, 4 }, { 3, 3 } };
        int n = 6;
        int result[] = gridIllumination(n, lamps, queries);
        System.out.println(Arrays.toString(result));
    }

    public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        HashMap<Long, Integer> diagonalUp = new HashMap<>();
        HashMap<Integer, Integer> diagonalDown = new HashMap<>();
        Set<Long> set = new HashSet<>();
        for (int l[] : lamps) {
            long hash = (long) l[0] * n + l[1];
            if (set.contains(hash))
                continue;
            set.add(hash);
            row.put(l[0], row.getOrDefault(l[0], 0) + 1);
            col.put(l[1], col.getOrDefault(l[1], 0) + 1);
            diagonalDown.put(l[1] - l[0], diagonalDown.getOrDefault(l[1] - l[0], 0) + 1);
            diagonalUp.put((long) l[1] + l[0], diagonalUp.getOrDefault((long) l[1] + l[0], 0) + 1);
        }
        int result[] = new int[queries.length];
        for (int i = 0; i < result.length; i++) {
            int bulbx = queries[i][0];
            int bulby = queries[i][1];

            if (row.getOrDefault(bulbx, 0) > 0 ||
                    col.getOrDefault(bulby, 0) > 0 ||
                    diagonalDown.getOrDefault(bulby - bulbx, 0) > 0 ||
                    diagonalUp.getOrDefault((long) bulbx + bulby, 0) > 0) {
                result[i] = 1;
            }

            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    int x = bulbx + j;
                    int y = bulby + k;
                    if (x >= 0 && y >= 0 && x < n && y < n && set.contains((long) x * n + y)) {
                        set.remove((long) x * n + y);
                        row.put(x, row.get(x) - 1);
                        col.put(y, col.get(y) - 1);
                        diagonalDown.put(y - x, diagonalDown.get(y - x) - 1);
                        diagonalUp.put((long) y + x, diagonalUp.get((long) y + x) - 1);
                    }
                }
            }
        }
        return result;
    }

}
