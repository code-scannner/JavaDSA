package codeforces.Round197;

import java.util.Scanner;

public class D {
    static class SegmentTree {
        int seg[];
        int orFirst;
        int no_overlap_val = 0;

        SegmentTree(int arr[], int n) {
            orFirst = n % 2;
            seg = new int[arr.length * 4];
            build(arr, 0, 0, arr.length - 1, orFirst);
        }

        private void build(int arr[], int idx, int low, int high, int or) {
            if (low == high) {
                seg[idx] = arr[low];
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            build(arr, left, low, mid, 1 - or);
            build(arr, right, mid + 1, high, 1 - or);
            seg[idx] = eval(seg[left], seg[right], or);
        }

        public int val() {
            return seg[0];
        }

        // update the index value to another
        public void update(int index, int value) {
            update(0, 0, seg.length / 4 - 1, index, value, orFirst);
        }

        private void update(int idx, int low, int high, int i, int val, int or) {
            if (low == high) {
                seg[idx] = val;
                return;
            }
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            if (i <= mid)
                update(left, low, mid, i, val, 1 - or);
            else
                update(right, mid + 1, high, i, val, 1 - or);
            seg[idx] = eval(seg[left], seg[right], or);
        }

        public int eval(int left, int right, int or) {
            return or == 1 ? left | right : left ^ right;
        }

    }

    public static void sol(int n, int arr[], int m, int[][] queries) {
        SegmentTree sg = new SegmentTree(arr, n);
        for (int[] q : queries) {
            sg.update(q[0] - 1, q[1]);
            System.out.println(sg.val());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[(int) Math.pow(2, n)];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = sc.nextInt();
        }
        int queries[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        sol(n, arr, m, queries);
        sc.close();
    }
}
