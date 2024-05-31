package codeforces.EDURound166;

import java.util.*;

public class A {
    public static boolean solve(int n, String s) {
        int i = 0;
        char prevDigit = '0';
        char prevChar = 'a';
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (prevChar > c)
                    return false;
                prevChar = c;
            } else if (Character.isDigit(c)) {
                if (prevDigit > c)
                    return false;
                prevDigit = c;
            }
            if (Character.isAlphabetic(c) && i < s.length() - 1 && Character.isDigit(s.charAt(i + 1)))
                return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            System.out.println(solve(n, s) ? "YES" : "NO");
        }
        sc.close();
    }
}
