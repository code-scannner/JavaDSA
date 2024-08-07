package segmenttree;

import java.util.*;

public class LazySetQuery {
    int seg[];
    int lazy[];
    int no_overlap_val = 0; // range queries for sum value

    LazySetQuery(int n) {
        seg = new int[n * 4];
        lazy = new int[n * 4];
        build(0, 0, n - 1);
    }

    public static void main(String[] args) {
        LazySetQuery lsq = new LazySetQuery(5);
        System.out.println(Arrays.toString(lsq.seg));
        int res = lsq.query(0, 4);
        System.out.println(Arrays.toString(lsq.seg));
        System.out.println(res);
    }

    // function used while adding left and right intervals
    public int eval(int left, int right) {
        return left + right;
    }

    private void build(int idx, int low, int high) {
        if (low == high) {
            seg[idx] = 1;
            return;
        }
        int mid = low + (high - low) / 2;
        int left = 2 * idx + 1;
        int right = left + 1;
        build(left, low, mid);
        build(right, mid + 1, high);
        System.out.println("Building for " + low + " " + high + " with idx = " + idx + " seg left = " + seg[left] + " seg right = " + seg[right]);
        seg[idx] = eval(seg[left], seg[right]);
    }

    // update the pending values whenever visiting the node
    public void updateLazy(int idx, int l, int r) {
        if (lazy[idx] == 0)
            return;
        seg[idx] = 0;
        if (l != r) {
            lazy[2 * idx + 1] = 1;
            lazy[2 * idx + 2] = 1;
        }
        lazy[idx] = 0;
    }

    // update the range from l to r adding with value
    public void off(int l, int r) {
        update(0, 0, seg.length / 4 - 1, l, r);
    }

    private void update(int idx, int low, int high, int l, int r) {

        updateLazy(idx, low, high);

        // no overlap condition
        if (low > r || high < l) {
            return;
        }
        // complete overlap
        else if (l <= low && high <= r) {
            lazy[idx] = 1;
            // updating here is important as we need the update value in the recursion
            updateLazy(idx, low, high);
            return;
        }
        // partial overlap
        else {
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            update(left, low, mid, l, r);
            update(right, mid + 1, high, l, r);
            seg[idx] = eval(seg[left], seg[right]);
        }
    }

    public int query(int left, int right) {
        return query(0, 0, seg.length / 4 - 1, left, right);
    }

    private int query(int idx, int low, int high, int l, int r) {

        // visit to low - high updates the node
        updateLazy(idx, low, high);

        // no overlap condition
        if (low > r || high < l) {
            return no_overlap_val;
        }
        // complete overlap
        else if (l <= low && high <= r) {
            return seg[idx];
        }
        // partial overlap
        else {
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            return eval(query(left, low, mid, l, r), query(right, mid + 1, high, l, r));
        }
    }

}
