package codeforces.Round944;

import java.util.Scanner;

public class C {
    public static boolean sol(int ax, int ay, int bx, int by) {
        int count = 0;
        for(int i = ax + 1; i != ay; i= (i + 1)%13){
            if(i == ay) break;
            if(i == bx) count++;
            if(i == by) count++;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int ax = sc.nextInt();
            int ay = sc.nextInt();
            int bx = sc.nextInt();
            int by = sc.nextInt();
            System.out.println(sol(ax, ay, bx, by) ? "YES" : "NO");
        }
        sc.close();
    }
}
