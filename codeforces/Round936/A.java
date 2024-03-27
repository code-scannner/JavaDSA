package codeforces.Round936;

import java.util.*;

public class A {
    public static int sol(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;
        int mid = (n + 1) / 2 - 1;
        int cnt = 0;
        for (int i = mid; i < n && arr[mid] == arr[i]; i++) {
            cnt++;
        }
        return cnt;
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
            System.out.println(sol(arr));
        }

        sc.close();
    }
}
