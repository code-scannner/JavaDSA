package segmenttree;

import java.util.*;


//Range set Point query
public class LazySetIndex {
    int seg[];
    int lazy[];
    int unassigned;

    LazySetIndex(int n, int unassigned_val) {
        unassigned = unassigned_val;
        // -1 means the node is not set yet
        seg = new int[n * 4];
        // -1 means there is nothing to set now
        lazy = new int[n * 4];
        Arrays.fill(seg, unassigned);
        Arrays.fill(lazy, unassigned);
    }

    // set the pending values whenever visiting the node
    public void setLazy(int idx, int l, int r) {
        if (lazy[idx] == unassigned)
            return;
        seg[idx] = lazy[idx];
        if (l != r) {
            lazy[2 * idx + 1] = lazy[idx];
            lazy[2 * idx + 2] = lazy[idx];
        }
        lazy[idx] = unassigned;
    }

    // set the range from l to r with value
    public void set(int l, int r, int value) {
        set(0, 0, seg.length / 4 - 1, l, r, value);
    }

    private void set(int idx, int low, int high, int l, int r, int val) {

        setLazy(idx, low, high);

        // no overlap condition
        if (low > r || high < l) {
            return;
        }
        // complete overlap
        else if (l <= low && high <= r) {
            lazy[idx] = val;
            // updating here is important as we need the set value in the recursion
            setLazy(idx, low, high);
            return;
        }
        // partial overlap
        else {
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            set(left, low, mid, l, r, val);
            set(right, mid + 1, high, l, r, val);
        }
    }

    public int query(int point) {
        return query(0, 0, seg.length / 4 - 1, point);
    }

    private int query(int idx, int low, int high, int point) {

        setLazy(idx, low, high);

        if (low == high) {
            return seg[idx];
        } else {
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            if (point <= mid) {
                return query(left, low, mid, point);
            } else
                return query(right, mid + 1, high, point);
        }
    }

}