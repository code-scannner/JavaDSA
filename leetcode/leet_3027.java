package leetcode;

import java.util.*;

public class leet_3027 {
    public static int numberOfPairs(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] < p2[0])
                    return -1;
                else if (p1[0] == p2[0])
                    return p2[1] - p1[1];
                return 1;
            }
        });

        for (int[] is : points) {
            System.out.println(Arrays.toString(is));
        }

        int count = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            int y1 = points[i][1];
            int maxy = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int y2 = points[j][1];
                if (y2 <= y1 && y2 > maxy) {
                    maxy = Math.max(maxy, y2);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // int[][] points = {
        // { 3, 1 }, { 1, 3 }, { 1, 1 }
        // };
        int[][] points = {
                { 2, 6 }, { 2, 4 }
        };
        System.out.println(numberOfPairs(points));

    }
}
