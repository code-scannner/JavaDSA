package rangequeries.sparsetable;

public class GCD {

    public static void main(String[] args) {
        int arr[] = { 1343 };
        SparseTable st = new SparseTable(arr);
        int ans = st.query(0, 0);
        System.out.println(ans);
    }

    public static class SparseTable {
        // for range gcd
        int arr[];
        int lookup[][];

        SparseTable(int a[]) {
            int n = a.length;
            arr = a;
            // values stored in lookup is the gcd of the array from index i to i + 2^j - 1;
            lookup = new int[n][1 + (int) Math.ceil(Math.log(n) / Math.log(2))]; // nlogn space

            // building process
            for (int i = 0; i < n; i++) {
                lookup[i][0] = arr[i];
            }
            for (int j = 1; j < lookup[0].length; j++) {
                int gap = (1 << (j - 1));
                for (int i = 0; i + gap + gap <= n; i++) {
                    lookup[i][j] = gcd(lookup[i][j - 1], lookup[i + gap][j - 1]);
                }
            }
        }

        int gcd(int d, int rem) {
            if (rem == 0)
                return d;
            return gcd(rem, d % rem);
        }

        int query(int l, int r) {
            int size = r - l + 1;
            int k = (int) (Math.log(size) / Math.log(2));
            return gcd(lookup[l][k], lookup[l + size - (1 << k)][k]);
        }

    }
}
