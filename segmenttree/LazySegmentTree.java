package segmenttree;

public class LazySegmentTree {
    int seg[];
    int lazy[];
    int no_overlap_val = 0; // range queries for sum value

    LazySegmentTree(int arr[]) {
        seg = new int[arr.length * 4];
        lazy = new int[arr.length * 4];
        build(arr, 0, 0, arr.length - 1);
    }

    // function used while adding left and right intervals
    public int eval(int left, int right) {
        return left + right;
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

    // update the pending values whenever visiting the node
    public void updateLazy(int idx, int l, int r) {
        if (lazy[idx] == 0)
            return;
        seg[idx] += (r - l + 1) * (lazy[idx]);
        if (l != r) {
            lazy[2 * idx + 1] += lazy[idx];
            lazy[2 * idx + 2] += lazy[idx];
        }
        lazy[idx] = 0;
    }

    // update the range from l to r adding with value
    public void update(int l, int r, int value) {
        update(0, 0, seg.length / 4 - 1, l, r, value);
    }

    private void update(int idx, int low, int high, int l, int r, int val) {

        updateLazy(idx, low, high);

        // no overlap condition
        if (low > r || high < l) {
            return;
        }
        // complete overlap
        else if (l <= low && high <= r) {
            lazy[idx] += val;
            // updating here is important as we need the update value in the recursion
            updateLazy(idx, low, high);
            return;
        }
        // partial overlap
        else {
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            update(left, low, mid, l, r, val);
            update(right, mid + 1, high, l, r, val);
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
