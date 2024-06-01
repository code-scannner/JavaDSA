package striverCP.maths;

import java.util.*;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println((sc.nextInt() * sc.nextInt() + 1) / 2);
        }
        sc.close();
    }
}
