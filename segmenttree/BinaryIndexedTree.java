package segmenttree;

// Fenwick Tree (Binary Indexed Tree) for Range Query + Point Update
public class BinaryIndexedTree {
    // 1-indexed internal tree
    int[] bit;

    // Build from array in O(n)
    public BinaryIndexedTree(int[] arr) {
        int n = arr.length;
        bit = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            bit[i] += arr[i - 1];
            int parent = i + (i & -i); // move to next segment
            if (parent <= n) {
                bit[parent] += bit[i];
            }
        }
    }

    // Empty BIT of given size
    public BinaryIndexedTree(int n) {
        bit = new int[n + 1];
    }

    // Add 'val' to index i (0-based index)
    public void add(int i, int val) {
        i++; // convert to 1-based
        while (i < bit.length) {
            bit[i] += val;
            i += i & -i; // move to next segment
        }
    }
    
    // Prefix sum from 0 to i (0-based index)
    public int sum(int i) {
        i++; // convert to 1-based
        int s = 0;
        while (i > 0) {
            s += bit[i];
            i -= i & -i; // move to previous segment
        }
        return s;
    }

    // Range sum from l to r inclusive (0-based indices)
    public int sum(int l, int r) {
        if (l > r) return 0; // safety
        return sum(r) - (l > 0 ? sum(l - 1) : 0);
    }
}
