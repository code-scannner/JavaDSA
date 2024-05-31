package codeforces.Round949;

import java.util.*;

public class A {
    public static void solve(int l) {
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int score = (int) (Math.log(r) / Math.log(2));
            System.out.println(score);
            solve(l);
        }
        sc.close();
    }
}
