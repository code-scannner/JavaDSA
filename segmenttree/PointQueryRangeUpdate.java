package segmenttree;

public class PointQueryRangeUpdate {
    public static void main(String[] args) {
        int arr[]  ={4,3,9,2,2,1,0};
        BinaryIndexedTree bit = new BinaryIndexedTree(arr);
        bit.rangeUpdate(0, 4, 4);
        bit.rangeUpdate(2, 5, 1);
        System.out.println(bit.get(5));
    }

    // fenwick tree for Range Update Point Query
    public static class BinaryIndexedTree {
        // 0 indexed tree
        int bit[];

        BinaryIndexedTree(int arr[]) {
            int n = arr.length;
            bit = new int[n];
            for (int i = 0; i < n; i++) {
                rangeUpdate(i, i, arr[i]);
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

        public void rangeUpdate(int l, int r, int val) {
            add(l, val);
            add(r + 1, -val);
        }

        public int get(int i) {
            int s = 0;
            while (i > 0) {
                s += bit[i];
                i = (i & (i + 1)) - 1; // moving to previous segment
            }
            return s;
        }
    }

}
