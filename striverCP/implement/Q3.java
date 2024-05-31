package striverCP.implement;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 0, col = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (sc.nextInt() == 1) {
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(Math.abs(row - 2) + Math.abs(col - 2));
        sc.close();
    }
}
