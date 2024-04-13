package codeforces.EDURound164;
import java.util.*;

public class A {
    public static boolean sol(int n, int m, int k) {
        int maxSameColored = (int)Math.ceil((double)n/m);
        return n - maxSameColored <= k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(sol(n, m, k) ? "NO" : "YES");
        }
        sc.close();
    } 
}
