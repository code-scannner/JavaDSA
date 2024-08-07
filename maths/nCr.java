package maths;

public class nCr {
    static int mod = (int) 1e9 + 7;
    static int max = (int) 2e5;

    static long[] fact = new long[max + 1];
    static {
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }
    }

    public static long pow(long n, int x, int range) {
        long result = 1L;
        while (x > 0) {
            if ((x & 1) == 1) {
                result = (result * n) % range;
            }
            n = n * n % range;
            x >>= 1;
        }

        return result;
    }

    // calculating with mod in division
    public static long combination_mod(int n, int r, int mod) {
        if (n < r || n < 0 || r < 0)
            return 0;
        return fact[n] * pow((fact[n - r] * fact[r]) % mod, mod - 2, mod) % mod;
    }

    // normal with range O(N)
    public static int combination(int n, int r, int range) {
        double res = 1;
        int ren = r;
        for (int i = 0; i < r; i++) {
            res = ((res * (n--)) / (ren--)) % mod;
        }
        return (int) Math.round(res);
    }

    // two loops O(N)
    public static int combination(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n--);
        }
        while (r > 0)
            res /= (r--);
        return res;
    }

    // Preprocessing O(N^2) , computation O(1)
    public static int[][] generate_pascal_rows(int maxn) {
        int[][] C = new int[maxn + 1][maxn + 1];
        C[0][0] = 1;
        for (int n = 1; n <= maxn; ++n) {
            C[n][0] = C[n][n] = 1;
            for (int k = 1; k < n; ++k)
                C[n][k] = C[n - 1][k - 1] + C[n - 1][k];
        }
        return C;
    }

    public static void main(String[] args) {
        // System.out.println(combination(8,3));
        // int mat[][] = generate_pascal_rows(10);
        // for (int arr[] : mat) {
        // System.out.println(Arrays.toString(arr));
        // }
        // System.out.println();
        System.out.println(combination_mod(10, 4, mod));
    }
}
