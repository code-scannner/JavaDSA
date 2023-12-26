package binarysearch;

public class Root {
    // return floor of root (n)
    public static int sqrt(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sq = mid * mid;
            if (sq == n)
                return mid;
            else if (sq > n)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return high;
    }

    public static int modified_pow(int n, int x, int target) {
        int result = 1;
        while (x > 0) {
            if (result > target || n > target)
                return Integer.MAX_VALUE;
            if ((x & 1) == 1) {
                result *= n;
            }
            n *= n;
            x >>= 1;
        }

        return result;
    }


    // returns value of nth root(num)
    public static int nthRoot(int num, int n) {
        int low = 1, high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int pow = modified_pow(mid, n, num);
            if (pow == num)
                return mid;
            else if (pow > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        // System.out.println(sqrt(5000));
        System.out.println(nthRoot(64,3));

    }
}
