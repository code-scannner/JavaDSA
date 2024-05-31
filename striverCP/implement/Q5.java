package striverCP.implement;

import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), l = sc.nextInt();
        System.out.println(Math.max(n, Math.max(k, l)) - Math.min(n, Math.min(l, k)));
        sc.close();
    }
}
