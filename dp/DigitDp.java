package dp;

import java.util.*;

public class DigitDp {
    public static long digitSum(long[][][] dp, int idx, int sum, int tight, List<Integer> digits) {

        // base case reached a solution
        if (idx == -1)
            return sum; // we can apply conditions to consider this value

        // memoization
        if (dp[idx][sum][tight] != -1)
            return dp[idx][sum][tight];

        long ret = 0L;
        int k = tight == 1 ? digits.get(idx) : 9;
        for (int i = 0; i <= k; i++) {
            ret += digitSum(dp,
                    idx - 1,
                    sum + i,
                    digits.get(idx) == i ? tight : 0,
                    digits);
        }

        dp[idx][sum][tight] = ret;

        return ret;

    }

    public static long digitSum(long num) {

        // base case for num == 0
        if (num == 0)
            return 0;

        // adding digits in form LSB to 0th index
        List<Integer> digits = new ArrayList<>();
        while (num != 0) {
            digits.add((int) (num % 10));
            num /= 10;
        }

        // dp state [idx][(sum | count | min etc. )][tight]
        long[][][] dp = new long[digits.size()][digits.size() * 9 + 1][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1L);
            }
        }

        return digitSum(dp, digits.size() - 1, 0, 1, digits);

    }

    public static void main(String[] args) {

        System.out.print("Enter range(1,x) - ");
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println("Digit Sum = " + (digitSum(b) - digitSum(a - 1)));

        sc.close();
    }
}
