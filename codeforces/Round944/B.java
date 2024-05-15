package codeforces.Round944;

import java.util.Scanner;

public class B {
    public static void sol(String x) {
        int i = 1;
        for (i = 1; i < x.length(); i++) {
            if (x.charAt(i) != x.charAt(0))
                break;
        }
        if (i == x.length()) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        StringBuilder str = new StringBuilder();
        str.append(x);
        char first = x.charAt(0);
        str.setCharAt(0, x.charAt(i));
        str.setCharAt(i, first);
        System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String x = sc.next();
            sol(x);
        }
        sc.close();
    }
}
