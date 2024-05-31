package striverCP.maths;

import java.util.*;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int max = Math.max(a, Math.max(b, c));
            int secondMax = max;
            int cnt = 0;
            if (a == max)
                cnt++;
            else
                secondMax = a;
            if (b == max)
                cnt++;
            else
                secondMax = b;
            if (c == max)
                cnt++;
            else
                secondMax = c;
            if (cnt < 2)
                System.out.println("NO");
            else {
                System.out.println("YES");
                System.out.println(max + " " + secondMax + " " + secondMax);
            }

        }
        sc.close();
    }
}
