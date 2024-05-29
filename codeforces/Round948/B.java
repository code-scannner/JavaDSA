package codeforces.Round948;

import java.util.*;
import java.util.Scanner;

public class B {

    public static List<Integer> sol(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            if (n % 2 == 0) {
                list.add(0);
                n /= 2;
            } else {
                if (n % 4 == 1) {
                    list.add(1);
                    n = (n - 1) / 2;
                } else {
                    list.add(-1);
                    n = (n + 1) / 2;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            List<Integer> list = sol(x);
            System.out.println(list.size());
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
