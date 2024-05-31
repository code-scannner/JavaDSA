package striverCP.implement;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = 0;
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            x += s.charAt(1) == '+' ? 1 : -1;
        }
        System.out.println(x);
        sc.close();
    }
}
