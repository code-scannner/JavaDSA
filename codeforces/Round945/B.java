package codeforces.Round945;

import java.util.Scanner;

public class B {
    public static int calcOr(int arr[]) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                num |= (1 << i);
            }
        }
        return num;
    }

    public static boolean isPossible(int dp[][], int k) {
        int freq[] = dp[k].clone();
        int xor = calcOr(freq);
        for (int j = 0; j < dp.length - k; j++) {
            freq = new int[20];
            for (int i = 0; i < 20; i++) {
                freq[i] = dp[j + k][i] - dp[j][i];
            }
            if (xor != calcOr(freq))
                return false;
        }
        return true;

    }

    public static int sol(int n, int arr[]) {
        int[][] dp = new int[n + 1][20];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 20; j++) {
                dp[i + 1][j] = dp[i][j] + ((arr[i] & (1 << j)) == 0 ? 0 : 1);
            }
        }

        // for(int a[] : dp){
        //     System.out.println(Arrays.toString(a));
        // }

        // for(int i = 1; i<=n; i++){
        //     System.out.printf("i = %d, sol = %s\n", i, isPossible(dp, i) ? "true" : "false");
        // }
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!isPossible(dp, mid)) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(sol(n, arr));
        }
        sc.close();
    }
}
