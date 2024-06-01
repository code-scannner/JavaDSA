package striverCP.maths;

import java.util.*;

public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(n == 1) System.out.println(0);
            else if(n == 2) System.out.println(m);
            else System.out.println(2*m);
        }
        sc.close();
    }
}