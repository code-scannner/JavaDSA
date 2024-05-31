package codeforces.Round949;

import java.util.*;

// TODO: NOT WORKING

public class C {
    public static void solve(int n, int arr[]) {
        int i = 0;
        while (i < n && arr[i] == -1)
            i++;
        if (i == n) {
            for (int j = 0; j < n; j++) {
                if (j % 2 == 0)
                    System.out.print(1 + " ");
                else
                    System.out.print(2 + " ");
            }
            return;
        }
        int j = i + 1;
        while (j < n) {
            if (arr[j] != -1) {
                if (!fill(arr, i, j)) {
                    System.out.println(-1);
                    return;
                }
                i = j;
            }
            j++;
        }
        boolean dou = true;
        for (int k = i + 1; k < n; k++) {
            if (dou)
                arr[k] = arr[k - 1] * 2;
            else
                arr[k] = arr[k - 1] / 2;
            dou = !dou;
        }

        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static boolean fill(int arr[], int i, int j) {
        if (i + 1 == j)
            return arr[i] == arr[j] / 2 || arr[i] / 2 == arr[j];
        int max = Math.max(arr[i], arr[j]);
        int min = Math.min(arr[i], arr[j]);
        int steps = (int) (Math.log((double) max / min) / Math.log(2));
        int emptySpaces = j - i - 1;
        if (steps - 1 > emptySpaces)
            return false;

        int k = i + 1;
        for (; steps > 1; steps--) {
            arr[k++] = max / 2;
            emptySpaces--;
        }
        if (emptySpaces % 2 == 1)
            return false;

        for (; emptySpaces > 0; emptySpaces -= 2) {
            arr[k++] = max * 2;
            arr[k++] = max / 2;
        }

        if (arr[i] == min) {
            reverse(arr, i + 1, j - 1);
        }

        return true;
    }

    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
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
            solve(n, arr);
        }
        sc.close();
    }
}
