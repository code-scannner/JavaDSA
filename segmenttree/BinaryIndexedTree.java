package segmenttree;

// fenwick tree for Range Query point update
public class BinaryIndexedTree {
    // 0 indexed tree
    int bit[];

    BinaryIndexedTree(int arr[]) {
        int n = arr.length;
        bit = new int[n];
        // linear construction O(n);
        for (int i = 0; i < n; i++) {
            bit[i] += arr[i];
            int next = i | (i + 1);
            if (next < n)
                bit[next] += bit[i];
        }
    }

    BinaryIndexedTree(int n) {
        bit = new int[n];
    }

    public void add(int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i |= (i + 1); // moving to next segment
        }
    }

    public int sum(int i) {
        int s = 0;
        while (i > 0) {
            s += bit[i];
            i = (i & (i + 1)) - 1; // moving to previous segment
        }
        return s;
    }

    public int sum(int l, int r) {
        return sum(r) - sum(l - 1);
    }
}
