package codeforces.Round937;

import java.util.*;

public class B {
    public static String getLine(int n, char a, char b) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                str.append(a);
                str.append(a);
            } else {
                str.append(b);
                str.append(b);
            }
        }
        return str.toString();
    }

    public static void sol(int n) {
        char s = '#', e = '.';
        for (int i = 0; i < n; i++) {
            String line = getLine(n, s, e);
            System.out.println(line);
            System.out.println(line);
            char temp = e;
            e = s;
            s = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            sol(a);
        }

        sc.close();
    }

}
