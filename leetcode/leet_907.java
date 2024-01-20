package leetcode;

import java.util.*;

class Pair {
    int num;
    int idx;

    Pair(int _n, int _i) {
        num = _n;
        idx = _i;
    }
}

public class leet_907 {
    public static int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        Stack<Pair> stk = new Stack<>();

        long dp[] = new long[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stk.isEmpty() && stk.peek().num >= arr[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                dp[i] = arr[i] * (i + 1);
            } else {
                dp[i] = (dp[stk.peek().idx] + (i - stk.peek().idx) * arr[i]) % mod;
            }
            stk.push(new Pair(arr[i], i));
        }

        long count = 0;
        for (long num : dp) {
            count = (count + num) % mod;
        }

        return (int) count;

    }

    public static int method2(int[] arr) {
        int mod = (int) 1e9 + 7;

        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        Stack<Pair> stk = new Stack<>();
        Stack<Pair> stk2 = new Stack<>();
        stk.push(new Pair(-1, -1));
        stk2.push(new Pair(-1, arr.length));
        for (int i = 0; i < arr.length; i++) {
            while (!stk.isEmpty() && stk.peek().num >= arr[i]) {
                stk.pop();
            }
            left[i] = i - stk.peek().idx;
            stk.push(new Pair(arr[i], i));

            while (!stk2.isEmpty() && stk2.peek().num >= arr[arr.length - i - 1]) {
                stk2.pop();
            }

            right[arr.length - i - 1] = stk2.peek().idx - (arr.length - i - 1);
            stk2.push(new Pair(arr[arr.length - i - 1], arr.length - i - 1));
        }

        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = (count + (long)left[i] * right[i] * arr[i]) % mod;
        }

        return (int) count;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 4 };
        System.out.println(sumSubarrayMins(arr));
    }
}
