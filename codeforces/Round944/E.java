package codeforces.Round944;

import java.util.Scanner;

// Not Working
public class E {
    public static int calcMins(int a[], int b[], int d) {
        if (d == a[a.length - 1])
            return b[a.length - 1];
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > d) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int a1 = right == -1 ? 0 : a[right], a2 = a[right + 1], b1 = right == -1 ? 0: b[right], b2 = b[right + 1];
        return a1 + (int)((d - a1) * (double) (b2 - b1) / (a2 - a1));

    }

    public static int[] sol(int n, int k, int q, int a[], int b[], int[] queries) {
        int result[] = new int[queries.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = calcMins(a, b, queries[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int q = sc.nextInt();
            int a[] = new int[k];
            for (int j = 0; j < k; j++) {
                a[j] = sc.nextInt();
            }
            int b[] = new int[k];
            for (int j = 0; j < k; j++) {
                b[j] = sc.nextInt();
            }
            int queries[] = new int[q];
            for (int j = 0; j < q; j++) {
                queries[j] = sc.nextInt();
            }
            int result[] = sol(n, k, q, a, b, queries);
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
