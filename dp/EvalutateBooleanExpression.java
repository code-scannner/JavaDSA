package dp;

import java.util.*;

public class EvalutateBooleanExpression {
    static int[] catlanNums;

    public static void formCatlannumbers() {
        catlanNums[0] = 1;
        catlanNums[1] = 1;
        catlanNums[2] = 1;
        for (int i = 3; i < catlanNums.length; i++) {
            int left = 1;
            int right = i - 1;
            int num = 0;
            while (left <= right) {
                num += catlanNums[left++] * catlanNums[right--];
            }
            num *= 2;
            if (i % 2 == 0)
                num -= catlanNums[i / 2] * catlanNums[i / 2];
            catlanNums[i] = num;
        }

    }

    public static boolean calc(boolean x, boolean y, char oper) {
        if (oper == '&')
            return x & y;
        if (oper == '|')
            return x | y;
        return x ^ y;
    }

    public static int recursion(int[][] dp, String exp, int i, int j) {
        if (i == j) {
            dp[i][j] = exp.charAt(2 * i) == 'F' ? 0 : 1;
            return dp[i][j];
        }

        int count = 0;
        for (int k = i; k < j; k++) {
            int leftT = recursion(dp, exp, i, k);
            int rightT = recursion(dp, exp, k + 1, j);
            int leftF = catlanNums[k - i + 1] - leftT;
            int rightF = catlanNums[j - k] - rightT;
            char oper = exp.charAt(2 * k + 1);
            if (calc(true, true, oper))
                count += leftT * rightT;
            if (calc(true, false, oper))
                count += leftT * rightF;
            if (calc(false, true, oper))
                count += leftF * rightT;
            if (calc(false, false, oper))
                count += leftF * rightF;

        }

        dp[i][j] = count;
        return count;
    }

    public static int memoHelper(int dp[][][], String s, int i, int l, int j, int k1, int k2) {
        return memoization(dp, s, i, l, k1) * memoization(dp, s, l + 1, j, k2);
    }

    public static int memoization(int dp[][][], String s, int i, int j, int k) {
        if (dp[i][j][k] != -1)
            return dp[i][j][k];

        if (i == j) {
            if (k == 0) {
                dp[i][j][k] = s.charAt(2 * i) == 'F' ? 1 : 0;
            } else {
                dp[i][j][k] = s.charAt(2 * i) == 'T' ? 1 : 0;
            }
        }

        int count = 0;
        for (int l = i; l < j; l++) {
            char c = s.charAt(2 * l + 1);
            switch (c) {
                case '&':
                    if (k == 0) {
                        count += memoHelper(dp, s, i, l, j, 0, 0) +
                                memoHelper(dp, s, i, l, j, 0, 1) +
                                memoHelper(dp, s, i, l, j, 1, 0);
                    } else {
                        count += memoHelper(dp, s, i, l, j, 1, 1);
                    }
                    break;
                case '|':
                    if (k == 0) {
                        count += memoHelper(dp, s, i, l, j, 0, 0);
                    } else {
                        count += memoHelper(dp, s, i, l, j, 1, 1) +
                                memoHelper(dp, s, i, l, j, 0, 1) +
                                memoHelper(dp, s, i, l, j, 1, 0);
                    }
                    break;
                case '^':
                    if (k == 0) {
                        count += memoHelper(dp, s, i, l, j, 1, 1) +
                                memoHelper(dp, s, i, l, j, 0, 0);
                    } else {
                        count += memoHelper(dp, s, i, l, j, 0, 1) +
                                memoHelper(dp, s, i, l, j, 1, 0);
                    }
                    break;
                default:
                    break;
            }

            dp[i][j][k] = count;
        }

        return dp[i][j][k];
    }


    public static int tabulation(String s) {
        int n = s.length();
        int dp[][][] = new int[(n + 1) / 2][(n + 1) / 2][2];

        for (int i = 0; i < dp.length; i++) {
            dp[i][i][0] = s.charAt(2 * i) == 'F' ? 1 : 0;
            dp[i][i][1] = s.charAt(2 * i) == 'T' ? 1 : 0;
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < dp.length; j++) {
                for (int l = i; l < j; l++) {
                    char c = s.charAt(2 * l + 1);
                    switch (c) {
                        case '&':

                            // for X & Y = false
                            dp[i][j][0] += (dp[i][l][0] * dp[l + 1][j][1]) + 
                            (dp[i][l][1] * dp[l + 1][j][0]) + 
                            (dp[i][l][0] * dp[l + 1][j][0]);

                            // for X & Y = true;
                            dp[i][j][1] += dp[i][l][1] * dp[l + 1][j][1] ;

                            break;
                        case '|':

                            // for X | Y = false;
                            dp[i][j][0] += dp[i][l][0] * dp[l + 1][j][0];

                            // for X | Y = true;
                            dp[i][j][1] +=  (dp[i][l][0] * dp[l + 1][j][1]) + 
                            (dp[i][l][1] * dp[l + 1][j][0]) + 
                            (dp[i][l][1] * dp[l + 1][j][1]);

                            break;
                        case '^':

                            // for X ^ Y = false;
                            dp[i][j][0] += (dp[i][l][0] * dp[l + 1][j][0]) + 
                            (dp[i][l][1] * dp[l + 1][j][1]);

                            // for X ^ Y = true;
                            dp[i][j][1] +=  (dp[i][l][0] * dp[l + 1][j][1]) + 
                            (dp[i][l][1] * dp[l + 1][j][0]);

                            break;
                        default:
                            break;
                    }
                }
            }
        }


        return dp[0][dp.length - 1][1];
    }

    public static void main(String[] args) {
        String exp = "T&T|T|F^F|T&T";
        int n = exp.length();
        catlanNums = new int[(n + 3) / 2];
        formCatlannumbers();

        int memo[][] = new int[(n + 1) / 2][(n + 1) / 2];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }

        System.out.println(
                recursion(memo, exp, 0, (n - 1) / 2));

        int dp[][][] = new int[(n + 1) / 2][(n + 1) / 2][2];
        for (int[][] is : dp) {
            for (int[] is2 : is) {
                Arrays.fill(is2, -1);
            }
        }

        System.out.println(memoization(dp, exp, 0, dp.length - 1, 1));

        System.out.println(tabulation(exp));

    }
}
