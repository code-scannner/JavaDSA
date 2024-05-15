package dp;

import java.util.*;

public class DigitDp {
    public static long digitSum(long[][][] dp, int idx, int sum, int tight, List<Integer> digits) {
        if (idx == -1)
            return sum;

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

        // let num = 3 2 4 5
        if (num == 0)
            return 0;
        List<Integer> digits = new ArrayList<>();
        while (num != 0) {
            digits.add((int)(num % 10));
            num /= 10;
        }

        // digits = 5 4 2 3

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
