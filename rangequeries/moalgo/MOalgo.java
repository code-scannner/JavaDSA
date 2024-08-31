package rangequeries.moalgo;

import java.util.*;

public class MOalgo {
    public static void main(String[] args) {
        int arr[] = { 1, 34, 5, 6, 7, 4, 1, 2, 3, 4 };
        MOalgo malgo = new MOalgo(arr);
        System.out.println(Arrays.toString(malgo.group));
        System.out.println(malgo.query(2, 4));
    }

    int[] group;
    int len;
    int arr[];

    MOalgo(int a[]) {
        int n = a.length;
        len = (int) Math.sqrt((double) n - 1) + 1;
        group = new int[len];
        arr = a;
        for (int i = 0; i < n; i++) {
            group[i / len] += a[i];
        }
    }

    public int query(int l, int r) {
        int sum = 0;
        while (l <= r) {
            if (l % len == 0 && l + len - 1 <= r) {
                sum += group[l / len];
                l += len;
            } else {
                sum += arr[l];
                l++;
            }
        }

        return sum;
    }
}
