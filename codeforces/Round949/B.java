package codeforces.Round949;

import java.util.*;

public class B {
    public static int OR(int l, int r) {
        int num = l;
        int or = l | r;
        for(int i = 0; i<31; i++){
            if((num & (1<<i)) == 0){
                num |= (1<<i);
                if(num <= r){
                    or |= (1<<i);
                }
            }
            num ^= (1<<i);
        }
        return or;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int l = Math.max(0, n - m );
            int r = n + m;
            int or = OR(l, r);
            System.out.println(or);
        }
        sc.close();
    }
}
