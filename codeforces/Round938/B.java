package codeforces.Round938;

import java.util.*;

public class B {
    public static boolean sol(int n, int c, int d, int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int num : arr)
            if (num > max)
                max = num;
        int a = max - (n - 1) * c - (n - 1) * d;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = a + i * c + j * d;
                int val = map.getOrDefault(num, 0);
                if (val == 0) {
                    return false;
                } else {
                    map.put(num, val - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int arr[] = new int[n * n];
            for (int j = 0; j < n * n; j++) {
                arr[j] = sc.nextInt();
            }

            System.out.println(sol(n, c, d, arr) ? "YES" : "NO");

        }
        sc.close();
    }
}
