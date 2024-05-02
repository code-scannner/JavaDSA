package codeforces.Round943;

import java.util.*;

public class B{

    public static int sol(int n, int m, String a, String b) {
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else
                j++;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            System.out.println(sol(n, m, a, b));

        }
        sc.close();
    }

}
