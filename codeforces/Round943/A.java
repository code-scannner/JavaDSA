package codeforces.Round943;

import java.util.*;

public class A {
    public static int gcd(int d, int rem) {
        if (rem == 0)
            return d;
        return gcd(rem, d % rem);
    }

    public static int sol(int x) {
        int max = Integer.MIN_VALUE;
        int y = -1;
        for (int i = 1; i < x; i++) {
            int result = gcd(x, i) + i;
            if (result > max) {
                max = result;
                y = i;
            }
        }

        return y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(sol(n));
        }
        sc.close();
    }

}
