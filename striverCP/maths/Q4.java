package striverCP.maths;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int evens = 0, odds = 0;
            while (n > 0) {
                if (sc.nextInt() % 2 == 0)
                    evens++;
                else
                    odds++;
                n--;
            }
            if (odds == 0 || odds % 2 == 0 && evens == 0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
        sc.close();
    }
}
