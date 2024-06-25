package rangequeries.sparsetable;

public class SparseTable {
    // for range minimum queries
    // can also be used to calculate the index of the minimum element in the range
    int arr[];
    int lookup[][];

    SparseTable(int a[]) {
        int n = a.length;
        arr = a;
        // values stored in lookup is the index of the minimum array from i to i + 2^j -
        // 1;
        lookup = new int[n][1 + (int) Math.ceil(Math.log(n) / Math.log(2))]; // nlogn space
        // max length is 1 for arr of 1 index only;

        // building process
        for (int i = 0; i < n; i++) {
            lookup[i][0] = i;
        }
        for (int j = 1; j < lookup[0].length; j++) {
            int gap = (1 << (j - 1));
            for (int i = 0; i + gap + gap <= n; i++) {
                if (arr[lookup[i][j - 1]] <= arr[lookup[i + gap][j - 1]]) { // for minimum condition
                    lookup[i][j] = lookup[i][j - 1];
                } else
                    lookup[i][j] = lookup[i + gap][j - 1];
            }
        }
    }

    int eval(int left, int right) {
        return Math.min(left, right);
    }

    int query(int l, int r) {
        int size = r - l + 1;
        int k = (int) (Math.log(size) / Math.log(2));
        return eval(arr[lookup[l][k]], arr[lookup[l + size - (1 << k)][k]]);
    }

}
