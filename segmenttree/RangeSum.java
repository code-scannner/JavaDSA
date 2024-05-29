package segmenttree;

public class RangeSum {
    public static void usingSegmentTree(int arr[]){
        SegmentTree sg = new SegmentTree(arr, 0) {
            @Override
            public int eval(int left, int right) {
                return left + right;
            }
        };
        System.out.println(sg.query(1, 3));
        sg.update(1, 1);
        System.out.println(sg.query(1, 3));
    }

    public static void usingBinaryIndexedTree(int arr[]){
        BinaryIndexedTree bitree = new BinaryIndexedTree(arr);
        System.out.println(bitree.sum(1));
        bitree.add(0, 5);
        System.out.println(bitree.sum(2));
        System.out.println(bitree.sum(1, 2));
    }

    public static void usingLazySegmentation(int arr[]){
        LazySegmentTree lsg = new LazySegmentTree(arr);
        System.out.println(lsg.query(1, 3));
        lsg.update(1, 3, 2);
        System.out.println(lsg.query(2, 5));
        System.out.println(lsg.query(1, 3));

    }
    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 0, 4, 5 };
        // usingSegmentTree(arr);
        // usingBinaryIndexedTree(arr);
        usingLazySegmentation(arr);
        
    }
}
