package codeforces.Round928;

import java.util.*;

public class B {

    public static boolean checkOccurence(int grid[][], int i, int j, int cnt) {
        int occured = 0;
        while (i < grid.length && j < grid.length) {
            if (grid[i][j] == 1) {
                occured++;
            } else
                break;

            j++;
        }
        return cnt == occured;
    }

    public static String func(int[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int cnt = 0, k = j;
                    while (k < n && grid[i][k] == 1) {
                        k++;
                        cnt++;
                    }
                    for (int m = i + 1; m < i + cnt; m++) {
                        if (!checkOccurence(grid, m, j, cnt))
                            return "TRIANGLE";
                    }
                    if(checkOccurence(grid, i + cnt, j, 0)){
                        return "SQUARE";
                    }
                    return "TRIANGLE";

                }
            }
        }
        return "TRIANGLE";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            int grid[][] = new int[n][n];
            for (int j = 0; j < n; j++) {
                int k = 0;
                for (char c : sc.next().toCharArray()) {
                    grid[j][k++] = c - '0';
                }
            }
            System.out.println(func(grid, n));
        }
        sc.close();
    }
}
