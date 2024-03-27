package codeforces.EDURound163;

import java.util.*;

public class A {
    public static String sol(int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append((i / 2) % 2 == 0 ? 'A' : 'B');
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int str = sc.nextInt();
            if (str % 2 == 1)
                System.out.println("NO");
            else {
                System.out.println("YES");
                System.out.println(sol(str));
            }
        }
        sc.close();
    }
}
