package codeforces.Round937;
import java.util.*;

public class A {
    public static String sol(int a, int b, int c) {
        if(a < b && b < c) return "STAIR";
        if(a < b && b > c) return "PEAK";
        return "NONE";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(sol(a,b,c));
        }

        sc.close();
    }
}
