package striverCP.maths;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i<t; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            if(2*l <= r) System.out.println(l + " " + 2*l);
            else System.out.println(-1 + " " + -1);
            
        }
        sc.close();
    }
}
