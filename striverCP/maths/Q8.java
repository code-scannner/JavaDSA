package striverCP.maths;

import java.util.*;

public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), n = sc.nextInt();
            boolean cando = (a + b + c + n) % 3 == 0 && Math.max(a, Math.max(b, c)) <= (a + b + c + n) / 3;
            System.out.println(cando ? "YES" : "NO");
        }
        sc.close();
    }
}
