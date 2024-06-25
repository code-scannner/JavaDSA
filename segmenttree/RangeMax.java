package segmenttree;

public class RangeMax {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 0, 4, 5 };
        // usingSegmentTree(arr); // Time = O(logn) Space O(n)
        forRangeUpdateMax(arr);
    }

    public static void usingSegmentTree(int arr[]){
        SegmentTree sg = new SegmentTree(arr, Integer.MIN_VALUE) {
            @Override
            public int eval(int left, int right) {
                return Math.max(left, right);
            }
        };
        System.out.println(sg.query(0, 3));
    }
    public static void forRangeUpdateMax(int arr[]){
        LazySegmentTree lsg = new LazySegmentTree(arr){
            @Override
            public void updateLazy(int idx, int l, int r) {
                if(lazy[idx] != 0){
                    seg[idx] += lazy[idx];
                    if(l != r){
                        lazy[2*idx + 1] += lazy[idx];
                        lazy[2*idx + 2] += lazy[idx];
                    }
                    lazy[idx] = 0;
                }
            };
            @Override
            public int eval(int left, int right) {
                return Math.max(left, right);
            };

        }   ;
        lsg.no_overlap_val = Integer.MIN_VALUE;

        System.out.println(lsg.query(1, 3));
        lsg.update(1, 4, 2);
        System.out.println(lsg.query(1, 3));
        System.out.println(lsg.query(4,5));

        
    }
    
}
