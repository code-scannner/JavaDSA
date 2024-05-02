package codeforces.Round943;

import java.util.*;

public class C {

    public static int[] sol(int n, int arr[]) {
        int result[] = new int[n];
        result[0] = 1000;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + arr[i - 1];
        }
        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int arr[] = new int[n - 1];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = sc.nextInt();
            }
            int result[] = sol(n, arr);
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

}
