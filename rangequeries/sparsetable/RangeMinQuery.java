package rangequeries.sparsetable;

public class RangeMinQuery {
    public static void main(String[] args) {
        int arr[] = {4,6,1,5,7,3};
        arr = new int[]{1, 3};
        SparseTable st = new SparseTable(arr);
        System.out.println(st.query(0, 0));
        System.out.println(st.query(0, 1));
        System.out.println(st.query(1, 1));
        
    }
}
