package segmenttree;

/*
    Given a set of coins [1, 1, 0, 0, 1, 1, 0]
    1 denotes head faced coin, 0 denotes tail faced coin
    Given some set of queries with format [l, r] which will flip the coins in that range
    Given another set of query to determine how many coins are faced head
 */

class Flip {
    int seg[];
    int lazy[];

    Flip(int arr[]) {
        seg = new int[arr.length * 4];
        lazy = new int[arr.length * 4];
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
        seg[idx] = seg[left] + seg[right];
    }

    // update the pending values whenever visiting the node
    public void updateLazy(int idx, int l, int r) {
        if (lazy[idx] == 0)
            return;
        seg[idx] = (r - l + 1) - seg[idx];
        if (l != r) {
            lazy[2 * idx + 1] = 1 - lazy[2 * idx + 1];
            lazy[2 * idx + 2] = 1 - lazy[2 * idx + 2];
        }
        lazy[idx] = 0;
    }

    public void flip(int l, int r) {
        flip(0, 0, seg.length / 4 - 1, l, r);
    }

    private void flip(int idx, int low, int high, int l, int r) {

        updateLazy(idx, low, high);

        // no overlap condition
        if (low > r || high < l) {
            return;
        }
        // complete overlap
        else if (l <= low && high <= r) {
            lazy[idx] = 1 - lazy[idx];
            updateLazy(idx, low, high);
            return;
        }
        // partial overlap
        else {
            int mid = low + (high - low) / 2;
            int left = 2 * idx + 1;
            int right = left + 1;
            flip(left, low, mid, l, r);
            flip(right, mid + 1, high, l, r);
            seg[idx] = seg[left] + seg[right];
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
            return 0;
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
            return query(left, low, mid, l, r) + query(right, mid + 1, high, l, r);
        }
    }

}

public class FlipCoin {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 0, 0, 1, 1, 0 };
        Flip lsg = new Flip(arr);

        System.out.println(lsg.query(1, 5));
        lsg.flip(3, 5);
        System.out.println(lsg.query(1, 5));
        lsg.flip(0, 6);
        System.out.println(lsg.query(0, 6));
        System.out.println(lsg.query(2, 6));
        System.out.println(lsg.query(2, 2));
        System.out.println(lsg.query(1, 1));

    }
}
