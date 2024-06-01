package striverCP.maths;

import java.util.*;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();
            int floor = n/x;
            int left = (floor - 1)*x;
            int right = floor * x;
            if(right + y <= n) System.out.println(right + y);
            else System.out.println(left + y);
        }
        sc.close();
    }
}