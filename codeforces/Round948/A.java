package codeforces.Round948;

import java.util.Scanner;

public class A {

    public static boolean sol(int n, int m) {
        if(m > n) return false;
        return (n - m)%2 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(sol(x, y) ? "YES" : "NO");
        }
        sc.close();
    }
}
