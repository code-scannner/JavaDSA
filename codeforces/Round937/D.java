package codeforces.Round937;

import java.util.*;

public class D {
    static int[] divisors = {
            10, 11, 100, 101,
            110, 111, 1000, 1001, 1010,
            1011, 1100, 1101, 1110, 1111,
            10000, 10001, 10010, 10011, 10100,
            10101, 10110, 10111, 11000, 11001,
            11010, 11011, 11100, 11101, 11110,
            11111, 100000
    };

    public static String sol(int n) {
        for (int i = divisors.length - 1; i >= 0; i--) {
            int div = divisors[i];
            if (n == 1)
                break;
            while (n % div == 0)
                n /= div;
        }
        return n == 1 ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            System.out.println(sol(a));
        }
        sc.close();
    }
}
