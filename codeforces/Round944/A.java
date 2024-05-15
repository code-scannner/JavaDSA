package codeforces.Round944;

import java.util.Scanner;

public class A {
    public static void sol(int x, int y) {
        System.out.print(Math.min(x, y) + " ");
        System.out.print(Math.max(x, y));
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sol(x, y);
        }
        sc.close();
    }
}
