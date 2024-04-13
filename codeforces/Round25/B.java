package codeforces.Round25;

import java.util.Scanner;

public class B {

    public static int sol(int n, int k, int[] arr) {
        int cowRating = arr[k - 1];
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] > cowRating)
                break;
        }
        if (i > k - 1)
            return i - 1;

        int j;
        for (j = i + 1; j < n; j++) {
            if (arr[j] >= cowRating)
                break;
        }

        return Math.max(i - 1, j - i - (i == 0 ? 1 : 0));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(sol(n, k, arr));
        }
        sc.close();
    }
}
