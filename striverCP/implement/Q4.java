package striverCP.implement;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), l = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt(), p = sc.nextInt(), nl = sc.nextInt(), np = sc.nextInt();
        System.out.println(Math.min(c*d, Math.min(k*l/nl, p/np))/n);
        sc.close();
    }
}
