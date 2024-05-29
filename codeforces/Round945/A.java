package codeforces.Round945;

import java.util.*;
import java.util.Scanner;

public class A {
    public static int solve(int dp[][][], int x, int y, int z) {
        if(x < 0 || y < 0 || z < 0) return -(int)1e9;
        if (dp[x][y][z] != -1)
            return dp[x][y][z];
        if (x == 0 && y == 0 || y == 0 && z == 0 || x == 0 && z == 0)
            return 0;
        dp[x][y][z] = 1 + Math.max(solve(dp, x - 1, y - 1, z),
                Math.max(solve(dp, x, y - 1, z - 1), solve(dp, x - 1, y, z - 1)));
        return dp[x][y][z];
    }

    public static int sol(int x, int y, int z) {
        int dp[][][] = new int[x + 1][y + 1][z + 1];
        for (int mat[][] : dp) {
            for (int arr[] : mat)
                Arrays.fill(arr, -1);
        }
        return solve(dp, x, y, z);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int result = sol(x, y, z);
            if((x + y + z) % 2 != 0) System.out.println(-1);
            else System.out.println(result);
        }
        sc.close();
    }
}
