package striverCP.maths;

import java.util.*;

public class Q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n % 4 == 0) {
                System.out.println("YES");
                int  currSum = 0;
                for (int i = 0; i < n/2; i++) {
                    System.out.print((i + 1)*2 + " ");
                    currSum += (i + 1)*2;
                }
                for (int i = 0; i < n/2 - 1; i++) {
                    currSum -= 2*i + 1;
                    System.out.print((2*i + 1)+ " ");
                }
                System.out.println(currSum);

            } else
                System.out.println("NO");
        }
        sc.close();
    }
}