package codeforces.EDURound166;

import java.util.*;

public class B {
    public static long solve(int n, int a[], int b[]) {
        int min = Integer.MAX_VALUE;
        long ans = 1;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(a[i] - b[i]);
            int l = Math.min(a[i], b[i]), r = Math.max(a[i], b[i]);
            if (l <= b[n] && b[n] <= r) {
                flag = true;
            }
            min = Math.min(min, Math.abs(l - b[n]));
            min = Math.min(min, Math.abs(r - b[n]));
        }

        if (flag)
            return ans;

        return ans + min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n + 1];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j <= n; j++) {
                b[j] = sc.nextInt();
            }
            System.out.println(solve(n, a, b));
            // System.out.println();
        }
        sc.close();
    }
}
