package striverCP.implement;

import java.util.*;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            int pow = 1;
            while (n > 0) {
                if (n % 10 != 0) {
                    list.add(pow * (n % 10));
                }
                pow *= 10;
                n /= 10;
            }
            System.out.println(list.size());
            for (int j = list.size() - 1; j >= 0; j--)
                System.out.print(list.get(j) + " ");
            System.out.println();
        }
        sc.close();
    }
}
