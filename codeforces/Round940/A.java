package codeforces.Round940;

import java.util.*;

public class A {
    public static int sol(int n, int arr[]) {
        Arrays.sort(arr);
        int prev = 0, cnt = 0, ans = 0;
        for (int num : arr) {
            if (num != prev) {
                ans += cnt / 3;
                prev = num;
                cnt = 0;
            } else
                cnt++;
        }
        ans += cnt / 3;
        return ans;
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
