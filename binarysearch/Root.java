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
        long result = 1;
        long curr = n;
        while (x > 0) {
            if (result > target || curr > target)
                return Integer.MAX_VALUE;
            if ((x & 1) == 1) {
                result *= curr;
            }
            curr *= curr;
            x >>= 1;
        }
        if(result > target) return Integer.MAX_VALUE;

        return (int)result;
    }


    // returns value of nth root(num) if integer
    // else returns -1
    public static int nthRoot(int num, int n) {
        int low = 1, high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(mid);
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
        System.out.println(nthRoot(67108864,13));
        // System.out.println(modified_pow(8, 13, 67108864));

    }
}
