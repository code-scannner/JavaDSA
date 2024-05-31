package striverCP.maths;

import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            if(n == 1  || n == 2) System.out.println(1);
            else System.out.println((n - 3)/x + 2);
        }
        sc.close();
    }
}
