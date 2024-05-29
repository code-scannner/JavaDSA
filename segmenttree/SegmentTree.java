package segmenttree;

// segment tree especially for min value queries

public class SegmentTree {
    int seg[];
    int no_overlap_val = Integer.MAX_VALUE; // range queries for min value

    SegmentTree(int arr[], int no_overlap_value) {
        seg = new int[arr.length * 4];
        no_overlap_val = no_overlap_value;
        build(arr, 0, 0, arr.length - 1);
    }

    private void build(int arr[], int idx, int low, int high) {
        if (low == high) {
            seg[idx] = arr[low];
            return;
        }
        int mid = low + (high - low) / 2;
        int left = 2 * idx + 1;
        int right = left + 1;
        build(arr, left, low, mid);
        build(arr, right, mid + 1, high);
        seg[idx] = eval(seg[left], seg[right]);
    }

    // function used while finding the query values
    public int eval(int left, int right) {
        return Math.min(left, right);
    }

    public int query(int left, int right) {
        return query(0, 0, seg.length / 4 - 1, left, right);
    }

    private int query(int idx, int low, int high, int l, int r) {
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

    // update the index value to another
    public void update(int index, int value) {
        update(0, 0, seg.length / 4 - 1, index, value);
    }

    private void update(int idx, int low, int high, int i, int val) {
        if (low == high) {
            seg[idx] = val;
            return;
        }
        int mid = low + (high - low) / 2;
        int left = 2 * idx + 1;
        int right = left + 1;
        if (i <= mid)
            update(left, low, mid, i, val);
        else
            update(right, mid + 1, high, i, val);
        seg[idx] = eval(seg[left], seg[right]);
    }

}
