package segmenttree;

public class BinaryIndexedTree {
    /// 1 indexed tree
    int index[];

    BinaryIndexedTree(int arr[]) {
        index = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            add(i, arr[i]);
        }
    }
    BinaryIndexedTree(int n) {
        index = new int[n + 1];
    }

    public void add(int i, int val) {
        i++; // 1 based indexing
        while (i < index.length) {
            index[i] += val;
            i += i & -i; // moving to child
        }
    }

    public int sum(int i) {
        i++; // 1 based indexing
        int s = 0;
        while (i > 0) {
            s += index[i];
            i -= i & -i; // moving to parent
        }
        return s;
    }

    public int sum(int l, int r) {
        return sum(r) - sum(l - 1);
    }
}
